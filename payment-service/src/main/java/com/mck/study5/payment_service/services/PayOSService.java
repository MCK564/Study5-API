package com.mck.study5.payment_service.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mck.study5.payment_service.models.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class PayOSService {

    @Value("${payos.client-id}")
    String clientId;

    @Value("${payos.api-key}")
    String apiKey;

    @Value("${payos.checksum-key}")
    String checksumKey;

    @Value("${payos.return-url}")
    String returnUrl;

    @Value("${payos.cancel-url}")
    String cancelUrl;

    private static final String CREATE_URL =
            "https://api-merchant.payos.vn/v2/payment-requests";

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Tạo link thanh toán PayOS từ đối tượng Payment trong DB.
     */
    public String createPaymentLink(Payment payment) {
        try {
            long orderCode = payment.getId();
            long amount = payment.getPrice();
            String description = payment.getDescription();

            // 1. Build body theo docs PayOS
            Map<String, Object> body = new LinkedHashMap<>();
            body.put("orderCode", orderCode);
            body.put("amount", amount);
            body.put("description", description);
            body.put("returnUrl", returnUrl);
            cancelUrl = cancelUrl.replace("{id}", payment.getId().toString());
            body.put("cancelUrl", cancelUrl);

            // Thông tin người mua (optional)
            body.put("buyerName", payment.getEmail());          // tạm dùng email
            body.put("buyerCompanyName", "N/A");
//            body.put("buyerTaxCode", "0333279377");                       // nếu có MST thì set
            body.put("buyerEmail", payment.getEmail());
            body.put("buyerPhone", "buyer not provide phone");
            body.put("buyerAddress", "buyer address");

            // Danh sách items (optional) – 1 item đại diện cho course
            Map<String, Object> item = new LinkedHashMap<>();
            item.put("name", "Course #" + payment.getCourseId());
            item.put("quantity", 1);
            item.put("price", amount);
            item.put("unit", "course");
            item.put("taxPercentage", 0);
            body.put("items", List.of(item));

            // Invoice (optional)
            Map<String, Object> invoice = new LinkedHashMap<>();
            invoice.put("buyerNotGetInvoice", true);
            invoice.put("taxPercentage", 0);
            body.put("invoice", invoice);

            // 2. Tạo raw string để ký (đúng thứ tự alphabet)
            String raw = "amount=" + amount
                    + "&cancelUrl=" + cancelUrl
                    + "&description=" + description
                    + "&orderCode=" + orderCode
                    + "&returnUrl=" + returnUrl;

            // 3. Tạo signature HMAC-SHA256 dạng hex
            String signature = HmacUtils.hmacSha256Hex(checksumKey, raw);
            body.put("signature", signature);

            // 4. Gọi API PayOS
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("x-client-id", clientId);
            headers.set("x-api-key", apiKey);

            HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    URI.create(CREATE_URL),
                    HttpMethod.POST,
                    request,
                    String.class
            );

            log.info("PayOS response status: {}", response.getStatusCode());
            log.info("PayOS response body: {}", response.getBody());

            if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
                throw new RuntimeException("PayOS create payment failed");
            }

            // 5. Parse JSON lấy data.checkoutUrl
            JsonNode root = objectMapper.readTree(response.getBody());
            String code = root.path("code").asText();
            if (!"00".equals(code)) {
                String desc = root.path("desc").asText();
                throw new RuntimeException("PayOS error: " + code + " - " + desc);
            }

            String checkoutUrl = root.path("data").path("checkoutUrl").asText();
            if (checkoutUrl == null || checkoutUrl.isEmpty()) {
                throw new RuntimeException("checkoutUrl not found in PayOS response");
            }

            return checkoutUrl;

        } catch (Exception e) {
            log.error("Error when creating PayOS payment link", e);
            throw new RuntimeException("Cannot create PayOS payment link", e);
        }
    }
}
