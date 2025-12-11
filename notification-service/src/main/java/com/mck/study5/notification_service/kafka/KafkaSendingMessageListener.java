package com.mck.study5.notification_service.kafka;


import com.mck.study5.notification_service.constants.Topics;
import com.mck.study5.notification_service.kafka.event.PaymentSuccessMessageEvent;
import com.mck.study5.notification_service.services.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaSendingMessageListener {
    private final MailService mailService;

    @KafkaListener(
            topics = Topics.NOTIFICATION_PAYMENT_SUCCESS,
            groupId = "notification-service",
            containerFactory = "sendingMessageKafkaListenerContainerFactory"
    )
    public void handlePaymentSuccessMessage(PaymentSuccessMessageEvent event){
        log.info("Sending payment success message event received: {}", event);

        if (event == null ) {
            log.warn("Sending message event not found: {}", event);
            return;
        }
        String toEmail = event.email();
        String html = """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>STUDY5 - Payment Confirmation</title>
    <style>
        body, html {
            margin: 0;
            padding: 0;
            background-color: #f5f5f7;
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", sans-serif;
        }
        table { border-collapse: collapse; }
        a { color: #2563eb; text-decoration: none; }

        .email-wrapper {
            width: 100%%;
            background-color: #f5f5f7;
            padding: 24px 0;
        }
        .email-container {
            width: 100%%;
            max-width: 600px;
            margin: 0 auto;
            background-color: #ffffff;
            border-radius: 12px;
            overflow: hidden;
            box-shadow: 0 10px 30px rgba(15, 23, 42, 0.08);
        }

        .email-header {
            background: linear-gradient(135deg, #2563eb, #1d4ed8);
            padding: 20px 32px;
            color: #ffffff;
        }
        .brand { font-size: 22px; font-weight: 700; }
        .brand span { color: #facc15; }
        .header-subtitle { font-size: 14px; opacity: 0.9; margin-top: 4px; }

        .email-body {
            padding: 24px 32px 8px 32px;
            color: #0f172a;
            font-size: 14px;
            line-height: 1.6;
        }

        .greeting { font-size: 16px; font-weight: 600; margin-bottom: 8px; }
        .highlight { color: #2563eb; font-weight: 600; }

        .info-box {
            margin-top: 20px;
            padding: 16px 18px;
            border-radius: 10px;
            background-color: #f1f5f9;
            border: 1px solid #e2e8f0;
        }
        .info-title { font-size: 14px; font-weight: 600; margin-bottom: 8px; }
        .info-row { font-size: 13px; margin: 2px 0; }
        .info-label {
            color: #64748b;
            width: 120px;
            display: inline-block;
        }
        .info-value { font-weight: 500; }

        .table-wrapper { margin-top: 20px; }
        .course-table {
            width: 100%%;
            border-radius: 10px;
            overflow: hidden;
            border: 1px solid #e2e8f0;
        }
        .course-table thead {
            background-color: #0f172a;
            color: #ffffff;
        }
        .course-table th,
        .course-table td {
            font-size: 13px;
            padding: 10px 12px;
        }

        .total-row {
            text-align: right;
            padding: 12px 4px 0 4px;
            font-size: 14px;
        }
        .total-label { color: #64748b; padding-right: 4px; }
        .total-value { font-weight: 700; color: #16a34a; }

        .email-footer {
            padding: 12px 32px 20px 32px;
            font-size: 12px;
            color: #64748b;
        }
        .footer-line {
            border-top: 1px solid #e2e8f0;
            margin: 12px 0;
        }
        .btn-primary {
            display: inline-block;
            margin-top: 18px;
            padding: 10px 18px;
            background-color: #2563eb;
            color: #ffffff !important;
            border-radius: 999px;
            font-size: 13px;
            font-weight: 600;
        }
        .muted { color: #94a3b8; }
    </style>
</head>
<body>
<div class="email-wrapper">
<table class="email-container" role="presentation" cellspacing="0" cellpadding="0" align="center">
<tr>
    <td class="email-header">
        <div class="brand">STUDY<span>5</span></div>
        <div class="header-subtitle">Thank you for your purchase – keep learning ✨</div>
    </td>
</tr>

<tr>
<td class="email-body">
    <p class="greeting">Xin chào <span class="highlight">%s</span>,</p>

    <p>
        Cảm ơn bạn đã đăng ký khóa học tại <strong>STUDY5</strong>.<br/>
        Thanh toán của bạn đã được ghi nhận thành công.
    </p>

    <div class="info-box">
        <div class="info-title">Thông tin thanh toán</div>
        <div class="info-row"><span class="info-label">Payment ID:</span><span class="info-value">%s</span></div>
        <div class="info-row"><span class="info-label">Email:</span><span class="info-value">%s</span></div>
        <div class="info-row"><span class="info-label">Thời gian:</span><span class="info-value">%s</span></div>
        <div class="info-row"><span class="info-label">Phương thức:</span><span class="info-value">%s</span></div>
        <div class="info-row"><span class="info-label">Trạng thái:</span><span class="info-value">PAID</span></div>
    </div>

    <div class="table-wrapper">
        <table class="course-table">
            <thead><tr><th>Khóa học </th><th align="right">Giá</th></tr></thead>
            <tbody>
                <tr><td>%s</td><td align="right">%s</td></tr>
            </tbody>
        </table>
    </div>

    <div class="total-row">
        <span class="total-label">Tổng thanh toán:</span>
        <span class="total-value">%s</span>
    </div>

    <a href="%s" class="btn-primary">Bắt đầu học ngay</a>
</td>
</tr>

<tr>
<td class="email-footer">
    <div class="footer-line"></div>
    <p>
        Nếu bạn không thực hiện giao dịch này hoặc cần hỗ trợ, vui lòng liên hệ
        <strong>STUDY5 Support</strong> tại
        <a href="mailto:support@study5.com">support@study5.com</a>.
    </p>
    <p class="muted">&copy; %s STUDY5. All rights reserved.</p>
</td>
</tr>

</table>
</div>
</body>
</html>
""".formatted(
                event.email(),
                event.paymentId(),
                event.email(),
                event.createdDate(),
                "PayOS",
                "ID Khóa học: "+ event.courseId(),
               event.amount()+" VND",
                event.amount()+" VND",
                "http://localhost:5173/courses/" + event.courseId(),
                java.time.Year.now().getValue()
        );


        try {
            mailService.sendHtmlEmail(
                    toEmail,
                    Topics.PAYMENT_BILL+" FOR PAYMENT_ID = " +event.paymentId(),
                        html
                    );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
