-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Host: mysql
-- Generation Time: Dec 11, 2025 at 06:24 AM
-- Server version: 8.0.28
-- PHP Version: 8.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `study5_product`
--

-- --------------------------------------------------------

--
-- Table structure for table `blogs`
--

CREATE TABLE `blogs` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `content` longtext,
  `subtitle` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `views` bigint DEFAULT NULL,
  `writer` varchar(255) DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `thumbnail_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `blogs`
--

INSERT INTO `blogs` (`id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `content`, `subtitle`, `title`, `views`, `writer`, `category_id`, `keywords`, `thumbnail`, `thumbnail_id`) VALUES
(1, NULL, '2025-11-23 04:57:36.563905', NULL, '2025-12-10 05:46:37.282946', '5', NULL, 'Quy trình thanh toán', 4, 'Lý Hoàng', NULL, NULL, NULL, NULL),
(2, NULL, '2025-11-23 04:57:56.991736', NULL, '2025-12-04 16:52:38.950253', '5', 'Blog hướng dẫn quy trình thanh toán khóa học online', 'Quy trình thanh toán', 2, 'Lý Hoàng', NULL, NULL, NULL, NULL),
(3, NULL, '2025-11-23 08:47:15.193531', NULL, '2025-12-10 05:46:34.325957', 'Cách làm câu hỏi về hàm ý câu nói trong đề TOEIC Listening Part 4\nTrong TOEIC Listening Part 4, có những lúc người nói không nói thẳng, mà lại \"gợi ý\" một điều gì đó qua giọng điệu, từ vựng hoặc ngữ cảnh. Đó chính là khi bạn gặp dạng câu hỏi về hàm ý câu nói - nơi kỹ năng suy luận và hiểu ngụ ý trở nên quan trọng hơn bao giờ hết. Không còn là việc nghe từ khóa đơn thuần, bạn cần đọc vị thông điệp ẩn sau lời nói, hiểu rõ người nói thực sự muốn truyền đạt điều gì. Bài viết này sẽ hướng dẫn bạn cách nhận diện các loại hàm ý thường gặp, dấu hiệu nhận biết tinh tế trong giọng điệu, và chiến lược làm bài giúp bạn xử lý dạng câu hỏi này một cách chính xác và tự tin hơn.\n\nI. Tổng quan chung về TOEIC Part 4\n...\n(BẢN ĐẦY ĐỦ RẤT DÀI — em sẽ bỏ toàn bộ 100% vào khi đại ka nói “OK, bỏ vào content blog”)\n', 'Trong bài viết này, STUDY4 sẽ giúp bạn làm chủ dạng câu hỏi về hàm ý câu nói bằng cách nhận diện ngụ ý, và tăng khả năng hiểu ngôn ngữ theo cách người bản ngữ thực sự sử dụng.', 'Cách làm câu hỏi về hàm ý câu nói trong đề TOEIC Listening Part 4', 10, 'Hải Yến', NULL, NULL, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/f3c10f8d-a1ad-428a-aecd-ab2885e0690f-toeic_1_1.webp', 20),
(5, NULL, '2025-12-04 16:55:15.079109', NULL, '2025-12-10 06:32:55.898755', '<h1><span style=\"color: rgb(5, 6, 15);\">Nằm lòng các mẹo thi TOEIC cực hiệu quả giúp bạn chinh phục điểm cao!</span></h1><ol><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><a href=\"https://prepedu.com/vi/content-publishing-rules\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: inherit;\">Quy tắc biên tập và xuất bản nội dung</a></li></ol><p><span style=\"color: rgb(35, 36, 45);\">Với 7 phần thi chính, mỗi phần của bài thi TOEIC yêu cầu các kỹ năng và chiến lược riêng biệt. Trong bài viết này, PREP sẽ chia sẻ các mẹo thi TOEIC để giúp bạn “rinh trọn” số điểm 990, giúp bạn tự tin vượt qua kỳ thi này và đạt kết quả xuất sắc nhé!</span></p><ol><li data-list=\"ordered\"><span class=\"ql-ui\" contenteditable=\"false\"></span><a href=\"https://prepedu.com/vi/blog/meo-thi-toeic?gad_source=1&amp;gad_campaignid=23261217302&amp;gbraid=0AAAAABWAD4moOVMPtE7lrqNSCtvbxwbPo&amp;gclid=Cj0KCQiA_8TJBhDNARIsAPX5qxQeW01qu25cLOlcK8gVXDy45oRoV-hrdJ1WSH4JccpLVTAadvL-D_0aAtRgEALw_wcB#toc-heading-1\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"background-color: rgb(250, 250, 250); color: rgb(35, 36, 45);\">I. Mẹo làm bài thi TOEIC phần nghe (Listening)</a></li><li data-list=\"ordered\" class=\"ql-indent-1\"><span class=\"ql-ui\" contenteditable=\"false\"></span><a href=\"https://prepedu.com/vi/blog/meo-thi-toeic?gad_source=1&amp;gad_campaignid=23261217302&amp;gbraid=0AAAAABWAD4moOVMPtE7lrqNSCtvbxwbPo&amp;gclid=Cj0KCQiA_8TJBhDNARIsAPX5qxQeW01qu25cLOlcK8gVXDy45oRoV-hrdJ1WSH4JccpLVTAadvL-D_0aAtRgEALw_wcB#toc-heading-2\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"background-color: rgb(250, 250, 250); color: rgb(35, 36, 45);\">1. Part 1</a></li><li data-list=\"ordered\" class=\"ql-indent-1\"><span class=\"ql-ui\" contenteditable=\"false\"></span><a href=\"https://prepedu.com/vi/blog/meo-thi-toeic?gad_source=1&amp;gad_campaignid=23261217302&amp;gbraid=0AAAAABWAD4moOVMPtE7lrqNSCtvbxwbPo&amp;gclid=Cj0KCQiA_8TJBhDNARIsAPX5qxQeW01qu25cLOlcK8gVXDy45oRoV-hrdJ1WSH4JccpLVTAadvL-D_0aAtRgEALw_wcB#toc-heading-3\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"background-color: rgb(250, 250, 250); color: rgb(35, 36, 45);\">2. Part 2</a></li><li data-list=\"ordered\" class=\"ql-indent-1\"><span class=\"ql-ui\" contenteditable=\"false\"></span><a href=\"https://prepedu.com/vi/blog/meo-thi-toeic?gad_source=1&amp;gad_campaignid=23261217302&amp;gbraid=0AAAAABWAD4moOVMPtE7lrqNSCtvbxwbPo&amp;gclid=Cj0KCQiA_8TJBhDNARIsAPX5qxQeW01qu25cLOlcK8gVXDy45oRoV-hrdJ1WSH4JccpLVTAadvL-D_0aAtRgEALw_wcB#toc-heading-4\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"background-color: rgb(250, 250, 250); color: rgb(35, 36, 45);\">3. Part 3 và Part 4</a></li><li data-list=\"ordered\"><span class=\"ql-ui\" contenteditable=\"false\"></span><a href=\"https://prepedu.com/vi/blog/meo-thi-toeic?gad_source=1&amp;gad_campaignid=23261217302&amp;gbraid=0AAAAABWAD4moOVMPtE7lrqNSCtvbxwbPo&amp;gclid=Cj0KCQiA_8TJBhDNARIsAPX5qxQeW01qu25cLOlcK8gVXDy45oRoV-hrdJ1WSH4JccpLVTAadvL-D_0aAtRgEALw_wcB#toc-heading-5\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"background-color: rgb(250, 250, 250); color: rgb(35, 36, 45);\">II. Mẹo làm bài thi TOEIC phần đọc (Reading)</a></li><li data-list=\"ordered\" class=\"ql-indent-1\"><span class=\"ql-ui\" contenteditable=\"false\"></span><a href=\"https://prepedu.com/vi/blog/meo-thi-toeic?gad_source=1&amp;gad_campaignid=23261217302&amp;gbraid=0AAAAABWAD4moOVMPtE7lrqNSCtvbxwbPo&amp;gclid=Cj0KCQiA_8TJBhDNARIsAPX5qxQeW01qu25cLOlcK8gVXDy45oRoV-hrdJ1WSH4JccpLVTAadvL-D_0aAtRgEALw_wcB#toc-heading-6\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"background-color: rgb(250, 250, 250); color: rgb(35, 36, 45);\">5. Part 5</a></li><li data-list=\"ordered\" class=\"ql-indent-1\"><span class=\"ql-ui\" contenteditable=\"false\"></span><a href=\"https://prepedu.com/vi/blog/meo-thi-toeic?gad_source=1&amp;gad_campaignid=23261217302&amp;gbraid=0AAAAABWAD4moOVMPtE7lrqNSCtvbxwbPo&amp;gclid=Cj0KCQiA_8TJBhDNARIsAPX5qxQeW01qu25cLOlcK8gVXDy45oRoV-hrdJ1WSH4JccpLVTAadvL-D_0aAtRgEALw_wcB#toc-heading-7\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"background-color: rgb(250, 250, 250); color: rgb(35, 36, 45);\">6. Part 6</a></li><li data-list=\"ordered\" class=\"ql-indent-1\"><span class=\"ql-ui\" contenteditable=\"false\"></span><a href=\"https://prepedu.com/vi/blog/meo-thi-toeic?gad_source=1&amp;gad_campaignid=23261217302&amp;gbraid=0AAAAABWAD4moOVMPtE7lrqNSCtvbxwbPo&amp;gclid=Cj0KCQiA_8TJBhDNARIsAPX5qxQeW01qu25cLOlcK8gVXDy45oRoV-hrdJ1WSH4JccpLVTAadvL-D_0aAtRgEALw_wcB#toc-heading-8\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"background-color: rgb(250, 250, 250); color: rgb(35, 36, 45);\">7. Part 7</a></li><li data-list=\"ordered\"><span class=\"ql-ui\" contenteditable=\"false\"></span><a href=\"https://prepedu.com/vi/blog/meo-thi-toeic?gad_source=1&amp;gad_campaignid=23261217302&amp;gbraid=0AAAAABWAD4moOVMPtE7lrqNSCtvbxwbPo&amp;gclid=Cj0KCQiA_8TJBhDNARIsAPX5qxQeW01qu25cLOlcK8gVXDy45oRoV-hrdJ1WSH4JccpLVTAadvL-D_0aAtRgEALw_wcB#toc-heading-9\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"background-color: rgb(250, 250, 250); color: rgb(35, 36, 45);\">III. Mẹo làm bài thi TOEIC Speaking and Writing</a></li><li data-list=\"ordered\" class=\"ql-indent-1\"><span class=\"ql-ui\" contenteditable=\"false\"></span><a href=\"https://prepedu.com/vi/blog/meo-thi-toeic?gad_source=1&amp;gad_campaignid=23261217302&amp;gbraid=0AAAAABWAD4moOVMPtE7lrqNSCtvbxwbPo&amp;gclid=Cj0KCQiA_8TJBhDNARIsAPX5qxQeW01qu25cLOlcK8gVXDy45oRoV-hrdJ1WSH4JccpLVTAadvL-D_0aAtRgEALw_wcB#toc-heading-10\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"background-color: rgb(250, 250, 250); color: rgb(35, 36, 45);\">1. Chiến lược làm bài thi TOEIC Speaking</a></li><li data-list=\"ordered\" class=\"ql-indent-1\"><span class=\"ql-ui\" contenteditable=\"false\"></span><a href=\"https://prepedu.com/vi/blog/meo-thi-toeic?gad_source=1&amp;gad_campaignid=23261217302&amp;gbraid=0AAAAABWAD4moOVMPtE7lrqNSCtvbxwbPo&amp;gclid=Cj0KCQiA_8TJBhDNARIsAPX5qxQeW01qu25cLOlcK8gVXDy45oRoV-hrdJ1WSH4JccpLVTAadvL-D_0aAtRgEALw_wcB#toc-heading-11\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"background-color: rgb(250, 250, 250); color: rgb(35, 36, 45);\">2. Chiến thuật làm bài thi TOEIC Writing</a></li></ol><p class=\"ql-align-center\"><span style=\"color: rgb(35, 36, 45);\"><img src=\"https://cms.prepedu.com/uploads/meo_thi_toeic_fbb1b0bb73.jpg\" alt=\"Mẹo thi TOEIC\"></span><em style=\"color: rgb(51, 51, 51); background-color: rgb(247, 247, 247);\">Mẹo thi TOEIC</em></p><h2><strong style=\"color: inherit;\">I. Mẹo làm bài thi TOEIC phần nghe (Listening)</strong></h2><p><strong style=\"color: inherit;\"><a href=\"https://prepedu.com/vi/blog/cau-truc-de-thi-toeic\" rel=\"noopener noreferrer\" target=\"_blank\">Cấu trúc đề thi TOEIC</a></strong><span style=\"color: rgb(35, 36, 45);\"> phần nghe sẽ có 4 phần, bao gồm:</span></p><ol><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><strong style=\"color: rgb(35, 36, 45);\">Part 1:</strong><span style=\"color: rgb(35, 36, 45);\"> Mô tả tranh</span></li><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><strong style=\"color: rgb(35, 36, 45);\">Part 2:</strong><span style=\"color: rgb(35, 36, 45);\"> Hỏi đáp</span></li><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><strong style=\"color: rgb(35, 36, 45);\">Part 3:</strong><span style=\"color: rgb(35, 36, 45);\"> Hội thoại</span></li><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><strong style=\"color: rgb(35, 36, 45);\">Part 4:</strong><span style=\"color: rgb(35, 36, 45);\"> Bài nói chuyện</span></li></ol><p><span style=\"color: rgb(35, 36, 45);\">Với cấu trúc khác nhau như vậy, bạn sẽ cần những chiến thuật làm bài thi TOEIC khác nhau cho từng phần. Cùng PREP tìm hiểu các mẹo làm bài thi TOEIC điểm cao phần Listening nhé!</span></p><h3><strong style=\"color: inherit;\">1. Part 1</strong></h3><p><span style=\"color: rgb(35, 36, 45);\">Part 1 sẽ yêu cầu bạn xem một bức tranh và chọn đáp án đúng trong 4 lựa chọn không được hiển thị sẵn. Những mẹo làm bài thi TOEIC Part 1 bạn có thể áp dụng đó là:</span></p><ol><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><strong style=\"color: rgb(35, 36, 45);\">Xem qua bức ảnh trước khi nghe: </strong><span style=\"color: rgb(35, 36, 45);\">Trước khi nội dung part 1 được phát, bạn hãy bắt đầu đọc các câu hỏi, hãy dành một chút thời gian để quan sát bức ảnh. Cố gắng xác định </span><a href=\"https://prepedu.com/vi/blog/tu-vung-toeic\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: rgb(26, 86, 219);\">từ vựng TOEIC</a><span style=\"color: rgb(35, 36, 45);\"> và động từ có thể xuất hiện trong câu hỏi. Hãy suy nghĩ về các câu hỏi như: ai, cái gì, khi nào, ở đâu.</span></li><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><strong style=\"color: rgb(35, 36, 45);\">Chú ý đến các hành động và vị trí</strong><span style=\"color: rgb(35, 36, 45);\">: Bức ảnh có thể miêu tả con người đang thực hiện các hành động, thường là các động từ ở dạng </span><a href=\"https://prepedu.com/vi/blog/thi-hien-tai-tiep-dien-present-continuous-tense\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: rgb(26, 86, 219);\">hiện tại tiếp diễn</a><span style=\"color: rgb(35, 36, 45);\"> (ví dụ: “He is repairing the machine”) hoặc thể </span><a href=\"https://prepedu.com/vi/blog/cau-bi-dong-passive-voice-trong-tieng-anh\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: rgb(26, 86, 219);\">bị động</a><span style=\"color: rgb(35, 36, 45);\"> (ví dụ: “The machine is being repaired”). Để trả lời chính xác, bạn cần lưu ý đến cả hành động và vị trí của người hoặc vật trong ảnh.</span></li><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><strong style=\"color: rgb(35, 36, 45);\">Chú ý đến các </strong><strong style=\"color: rgb(26, 86, 219);\"><a href=\"https://prepedu.com/vi/blog/gioi-tu-trong-tieng-anh\" rel=\"noopener noreferrer\" target=\"_blank\">giới từ</a></strong><span style=\"color: rgb(35, 36, 45);\">: Các câu hỏi có thể liên quan đến vị trí của người hoặc vật trong ảnh, sử dụng các giới từ chỉ vị trí (beside, in front of, next to,...) hoặc giới từ chỉ sự chuyển động (towards, through, across,...). Hãy cẩn thận vì hành động có thể đúng nhưng vị trí của người hoặc vật có thể sai.</span></li><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><strong style=\"color: rgb(35, 36, 45);\">Chú ý đến những chi tiết nhỏ:</strong><span style=\"color: rgb(35, 36, 45);\"> Bạn cần phải chú ý quan sát kỹ lưỡng mọi chi tiết trong bức hình, kể cả những điểm có vẻ không đáng kể. Mặc dù không phổ biến, nhưng đôi khi đề thi sẽ đưa ra những câu hỏi về các chi tiết nhỏ nhặt thay vì tập trung vào những yếu tố nổi bật của bức ảnh. Đây là một chiến thuật được người ra đề sử dụng nhằm kiểm tra khả năng quan sát tỉ mỉ của thí sinh và tránh việc thí sinh chỉ tập trung vào những chi tiết chính mà bỏ qua các yếu tố phụ trong hình.</span></li><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><strong style=\"color: rgb(35, 36, 45);\">Đừng dựa vào giả định</strong><span style=\"color: rgb(35, 36, 45);\">: Để chọn câu trả lời đúng, bạn cần dựa vào những gì thật sự có trong bức ảnh, không phải vào giả định của mình. Hãy chắc chắn rằng câu trả lời đúng dựa trên những gì bạn thấy trong hình ảnh, không phải chỉ là những gì bạn nghĩ.</span></li><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><strong style=\"color: rgb(35, 36, 45);\">Kiểm tra lại sau khi kết thúc</strong><span style=\"color: rgb(35, 36, 45);\">: Nếu đang luyện tập tại nhà, sau khi hoàn thành Part 1, bạn nên dừng lại để kiểm tra các câu trả lời. Ghi lại bất kỳ từ vựng mới nào xuất hiện trong các đáp án và suy nghĩ về lý do tại sao một số đáp án lại sai. Điều này sẽ giúp bạn cải thiện khả năng nhận diện các hình ảnh và hiểu các câu hỏi trong các lần thi sau.</span></li></ol><p><span style=\"color: rgb(35, 36, 45);\">Hãy cùng xem qua ví dụ sau cho dễ hiểu nhé:</span></p><p class=\"ql-align-center\"><span style=\"color: rgb(35, 36, 45);\"><img src=\"https://static-assets.prepcdn.com/content-management-system/vi_du_ve_meo_part_1_cac59edda0.jpg\" alt=\"vi-du-ve-meo-part-1.jpg\"></span><em style=\"color: rgb(51, 51, 51); background-color: rgb(247, 247, 247);\">Ví dụ về mẹo Part 1</em></p><p><span style=\"color: rgb(35, 36, 45);\">Từ bức ảnh trên, bạn có thể thử suy đoán về bức tranh như sau:</span></p><ol><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><span style=\"color: rgb(35, 36, 45);\">Hoạt động: Một cô gái đang cười và nghe điện thoại. Các từ bạn có thể liên tưởng bao gồm: smile, phone call, hold, laptop,...</span></li><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><span style=\"color: rgb(35, 36, 45);\">Ngữ cảnh chung: Cảnh trong ảnh có vẻ như diễn ra tại một văn phòng, vì cô gái đang mặc trang phục công sở và trên bàn làm việc có laptop, hộp bút, sổ,... Một đáp án có thể xuất hiện trong phần nghe như “There is laptop on the desk”.</span></li><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><span style=\"color: rgb(35, 36, 45);\">Mối quan hệ giữa các vật: Hộp bút ở trước cái laptop hay cuốn sổ tay nằm sau cái điện thoại bàn,...</span></li><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><span style=\"color: rgb(35, 36, 45);\">Những điểm ít được chú ý hơn: Tệp hồ sơ ở kệ, tệp visit card trên bàn,...</span></li></ol><h3><strong style=\"color: inherit;\">2. Part 2</strong></h3><p><span style=\"color: rgb(35, 36, 45);\">Ở part 2, bạn sẽ được nghe một câu hỏi/câu nói và chọn câu trả lời trong 3 đáp án không hiện sẵn. 08 mẹo làm bài thi TOEIC part 2 giúp bạn nâng cao điểm số bao gồm:</span></p><ol><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><strong style=\"color: rgb(35, 36, 45);\">Tập trung vào danh sách câu hỏi</strong><span style=\"color: rgb(35, 36, 45);\">: Dù bạn chọn hình thức thi online hay thi giấy thì cũng hãy chú ý đến vị trí câu hỏi đang được audio nhắc đến. Vì cả câu hỏi và câu trả lời đều không hiện sẵn nên bạn sẽ rất dễ lạc mất vị trí câu hỏi. Điều này có thể dễ dẫn đến tình trạng chọn được đáp án đúng nhưng lại sai câu, khiến bạn mất điểm một cách đáng tiếc.</span></li><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><strong style=\"color: rgb(35, 36, 45);\">Giữ câu hỏi trong tâm trí</strong><span style=\"color: rgb(35, 36, 45);\">: Khi nghe ba câu trả lời, hãy suy nghĩ và chọn câu trả lời có ý nghĩa hợp lý với câu hỏi. Những câu hỏi bắt đầu với các từ như “who, what, when, where, why” thường yêu cầu một câu trả lời logic. Chẳng hạn, những câu hỏi bắt đầu bằng “when” thì bạn cần chú ý đến những đáp án liên quan đến thời gian chứ không phải về địa điểm hay đối tượng.</span></li><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><strong style=\"color: rgb(35, 36, 45);\">Câu trả lời đôi khi không trực tiếp</strong><span style=\"color: rgb(35, 36, 45);\">: Đôi khi câu trả lời tốt nhất không phải là câu trả lời trực tiếp cho câu hỏi. Ví dụ, câu hỏi \"How many applicants applied for the position?\" có thể có câu trả lời là \"I’m disappointed because we haven’t received as many CVs as we expected.\" Điều này phản ánh cách sử dụng tiếng Anh trong thực tế, câu trả lời không phải lúc nào cũng liên quan đến ngữ pháp của câu hỏi.</span></li><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><strong style=\"color: rgb(35, 36, 45);\">Chú ý đến câu hỏi có \"question tags\"</strong><span style=\"color: rgb(35, 36, 45);\">: Bạn sẽ gặp câu hỏi dạng </span><a href=\"https://prepedu.com/vi/blog/cau-hoi-duoi-tag-questions-trong-tieng-anh\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: rgb(26, 86, 219);\">question tags</a><span style=\"color: rgb(35, 36, 45);\"> trong Part 2. Ví dụ, câu hỏi \"You reserved the conference room, didn’t you?\" thì câu trả lời có thể là \"Yes, I did.\" hoặc \"No, I didn’t.\" Hãy chú ý và chọn câu trả lời chính xác với câu hỏi có dạng này.</span></li><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><strong style=\"color: rgb(35, 36, 45);\">Cẩn thận với các câu hỏi về từ có nhiều nghĩa:</strong><span style=\"color: rgb(35, 36, 45);\"> Một trong những thử thách lớn khi làm bài thi TOEIC, đặc biệt là trong các phần nghe, là việc phải đối mặt với các từ đồng âm nhưng có nghĩa khác nhau. Đây là một trong những “bẫy” mà người thi dễ bị lừa.  Ví dụ, từ </span><em style=\"color: rgb(35, 36, 45);\">\"bark\"</em><span style=\"color: rgb(35, 36, 45);\"> có thể có nghĩa là vỏ cây hoặc tiếng sủa của chó, nhưng nếu câu nghe liên quan đến động vật, khả năng cao từ này có nghĩa là tiếng sủa của chó.</span></li><li data-list=\"bullet\"><span class=\"ql-ui\" contenteditable=\"false\"></span><strong style=\"color: rgb(35, 36, 45);\">Chú ý những </strong><strong style=\"color: rgb(26, 86, 219);\"><a href=\"https://prepedu.com/vi/blog/tu-dong-am-khac-nghia-trong-tieng-anh\" rel=\"noopener noreferrer\" target=\"_blank\">từ đồng âm khác nghĩa</a></strong><strong style=\"color: rgb(35, 36, 45);\">:</strong><span style=\"color: rgb(35, 36, 45);\"> Đối với những câu hỏi khó, bạn cũng sẽ gặp phải các từ có cách phát âm giống nhau hoặc gần giống nhau nhưng mang nghĩa hoàn toàn khác nhau. Ví dụ: </span><em style=\"color: rgb(35, 36, 45);\">\"read\"</em><span style=\"color: rgb(35, 36, 45);\"> (đọc) và </span><em style=\"color: rgb(35, 36, 45);\">\"reed\"</em><span style=\"color: rgb(35, 36, 45);\"> (cây sậy) mặc dù phát âm giống nhau nhưng có cách sử dụng khác nhau. Lắng nghe xem từ đó có được sử dụng như một động từ hay danh từ, giúp bạn phân biệt được chúng.</span></li></ol><p><br></p>', 'Kế hoạch chuẩn bị : trước thi 1 tháng', 'Kinh nghiệm ôn tập Toeic ', 1, '10', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `blog_category`
--

CREATE TABLE `blog_category` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `blog_category`
--

INSERT INTO `blog_category` (`id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `name`) VALUES
(1, NULL, '2025-11-23 04:25:34.910583', NULL, '2025-11-23 04:25:34.910632', 'Tính năng hệ thống'),
(2, NULL, '2025-11-23 04:26:04.299870', NULL, '2025-11-23 04:26:04.299895', 'Review của học viên IELTS'),
(3, NULL, '2025-11-23 04:26:08.702491', NULL, '2025-11-23 04:26:08.702563', 'Review của học viên TOEIC'),
(4, NULL, '2025-11-23 04:26:23.396761', NULL, '2025-11-23 04:26:23.396781', 'IELTS Listening'),
(5, NULL, '2025-11-23 04:26:30.214805', NULL, '2025-11-23 04:26:30.215128', 'IELTS Reading'),
(6, NULL, '2025-11-23 04:26:36.883782', NULL, '2025-11-23 04:26:36.883902', 'IELTS Speaking'),
(7, NULL, '2025-11-23 04:26:45.620988', NULL, '2025-11-23 04:26:45.621013', 'IELTS Writing'),
(8, NULL, '2025-11-23 04:27:06.242042', NULL, '2025-11-23 04:27:06.242062', 'Kinh nghiệm thi IELTS'),
(9, NULL, '2025-11-23 04:27:21.280083', NULL, '2025-11-23 04:27:21.280104', 'TOEIC Listening'),
(10, NULL, '2025-11-23 04:27:27.525682', NULL, '2025-11-23 04:27:27.525710', 'TOEIC Reading'),
(11, NULL, '2025-11-23 04:27:35.396217', NULL, '2025-11-23 04:27:35.396246', 'TOEIC Materials'),
(12, NULL, '2025-11-23 04:27:51.681644', NULL, '2025-11-23 04:27:51.681676', 'TOEIC Speaking & Writing'),
(13, NULL, '2025-11-23 04:28:05.993459', NULL, '2025-11-23 04:28:05.993490', 'Thông tin ky thi TOEIC'),
(14, NULL, '2025-11-23 04:28:18.185320', NULL, '2025-11-23 04:28:18.185343', 'Kinh nghiệm thi TOEIC'),
(15, NULL, '2025-11-23 04:28:41.946696', NULL, '2025-11-23 04:28:41.946726', 'Tiếng Trung cơ bản'),
(16, NULL, '2025-11-23 04:28:57.496384', NULL, '2025-11-23 04:28:57.496407', 'Kiến thức HSK-HSKK'),
(17, NULL, '2025-11-23 04:29:11.860917', NULL, '2025-11-23 04:29:11.860941', 'Thông tin kỳ thi HSK-HSKK'),
(18, NULL, '2025-11-23 04:29:38.496393', NULL, '2025-11-23 04:29:38.496416', 'Tài liệu AWS'),
(19, NULL, '2025-11-23 04:29:52.489522', NULL, '2025-11-23 04:29:52.489548', 'Kinh nghiệm thi chứng chỉ AWS'),
(20, NULL, '2025-12-03 08:08:44.009370', NULL, '2025-12-03 08:08:56.822115', 'Japan N2');

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `assignment` int DEFAULT NULL,
  `expire_time` varchar(255) DEFAULT NULL,
  `final_price` double DEFAULT NULL,
  `initial_price` double DEFAULT NULL,
  `introduction_video` varchar(255) DEFAULT NULL,
  `registered_student` int DEFAULT NULL,
  `teacher_description` varchar(255) DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `subject_id` bigint DEFAULT NULL,
  `users` varbinary(255) DEFAULT NULL,
  `thumbnail_id` bigint DEFAULT NULL,
  `thumbnail_url` varchar(255) DEFAULT NULL,
  `study_time` int DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `assignment`, `expire_time`, `final_price`, `initial_price`, `introduction_video`, `registered_student`, `teacher_description`, `thumbnail`, `subject_id`, `users`, `thumbnail_id`, `thumbnail_url`, `study_time`, `description`, `name`) VALUES
(1, NULL, NULL, NULL, '2025-12-03 08:02:09.900546', 514, '12/12/2027', 989000, 1800000, '', 36603, 'Mr Huy', NULL, 1, 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000077040000000078, 33, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/93846345-ef42-4f01-b7bb-38cb7adeedd5-toeic%201.jpg', NULL, 'Khoá học Complete TOEIC do STUDY5 biên soạn và xây dựng gồm bài giảng dạy chi tiết kỹ lưỡng các chủ điểm ngữ pháp quan trọng và tất cả các dạng câu hỏi trong bài thi TOEIC Listening và Reading', '[Complete TOEIC] Chiến lược làm bài - Từ vựng - Ngữ pháp - Luyện nghe với Dictation [Tặng TED Talks'),
(4, NULL, '2025-11-23 03:06:26.941371', NULL, '2025-11-24 08:01:53.704898', 500, '12/12/2027', 989000, 1800000, '', NULL, 'Mr Huy', NULL, 1, NULL, 19, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/83238cc7-31e2-470f-8a66-3a5f3a5af223-toeic_1_1.webp', NULL, 'Khoá học TOEIC Speaking & Writing do STUDY5 biên soạn và xây dựng gồm lý thuyết, video bài giảng dạy chi tiết tất cả các dạng câu hỏi trong bài thi TOEIC Speaking và Writing.  ', 'TOEIC SW] TOEIC Speaking and Writing [Tặng TED Talks]'),
(5, NULL, '2025-11-23 03:35:45.423047', NULL, '2025-12-03 08:02:52.965844', 177, '12/11/2026', 699000, 899000, '', 16335, 'Ms. Uyen Tran, FTU. IELTS 8.0 (Listening 8.5, Reading 8.5)', NULL, 2, NULL, 34, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/8ee51a5a-07f7-4521-9b5f-15b4fbdfdc2e-ielts%203.png', NULL, ' Xây dựng vốn từ vựng học thuật, làm nền móng để đọc/nghe hiểu các chủ điểm chắc chắn sẽ xuất hiện trong 2 phần thi Listening và Reading', '[IELTS Fundamentals] Từ vựng và ngữ pháp cơ bản IELTS'),
(6, NULL, '2025-11-23 03:41:25.511723', NULL, '2025-12-03 08:03:11.419015', 488, '12/11/2026', 699000, 899000, '', 16335, 'Ms. Phuong Nguyen, Macalester College, USA. TOEFL 114, IELTS 8.0, SAT 2280, GRE Verbal 165/170', NULL, 2, NULL, 35, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/c13fcc25-76b3-44c9-83a6-d75b97827064-ielts%205.png', NULL, 'Khóa học cung cấp video bài giảng hướng dẫn chi tiết cách làm từng dạng câu hỏi trong IELTS Listening và hơn 200h clip chữa chi tiết.', '[IELTS Intensive Listening] Chiến lược làm bài - Chữa đề - Luyện nghe IELTS Listening theo phương pháp Dictation'),
(7, NULL, '2025-11-23 03:42:35.575247', NULL, '2025-12-04 15:34:48.067579', 217, '12/11/2026', 699000, 899000, '', 18099, 'Mr. Hùng Nguyễn, HANU. IELTS 8.5 (Writing 8.0, Speaking 8.0), TESOL', NULL, 2, NULL, 58, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/4ea9a94a-062c-4c8c-84c3-03f831ee4164-ielts7.png', NULL, 'Khóa học cung cấp bài giảng hướng dẫn chi tiết cách làm IELTS Writing Task 1 và 2. Toàn bộ các bài samples trong bài giảng đều có điểm band 8.0+ và được chấm bới các cựu giám khảo IELTS.', '[IELTS Intensive Writing] Thực hành luyện tập IELTS Writing'),
(8, NULL, '2025-11-23 03:43:49.599725', NULL, '2025-12-04 15:29:54.767526', 666, '12/11/2026', 699000, 899000, '', 2595, 'Mr. Hùng Nguyễn, HANU. IELTS 8.5 (Writing 8.0, Speaking 8.0), TESOL', NULL, 3, NULL, 48, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/702a99d0-7809-4f6c-9639-4451dfdc9b86-ielts%206.png', NULL, 'Khóa học cung cấp bài giảng hướng dẫn chi tiết cách làm từng dạng câu hỏi trong IELTS Reading General Training và chữa đề chi tiết tất cả các câu hỏi trong nhiều bộ đề nổi tiếng, sát thi thật.', '[IELTS General Training] Intensive Reading: Từ Vựng - Chiến Lược Làm Bài - Chữa đề chi tiết'),
(9, NULL, '2025-11-23 03:44:59.518238', NULL, '2025-12-04 15:36:36.810746', 178, '12/11/2026', 699000, 899000, '', 3950, 'Mr. Hùng Nguyễn, HANU. IELTS 8.5 (Writing 8.0, Speaking 8.0), TESOL', NULL, 3, NULL, 60, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/ada809c8-9fe8-4df7-a493-f3ea37bca42d-ielts7.png', NULL, 'Khóa học IELTS General Intensive Writing cung cấp cho bạn những bài luyện tập để đạt điểm số cao trong phần thi này.', '[IELTS General Training] Intensive Writing: Thực hành luyện tập Writing GT'),
(10, NULL, '2025-11-23 03:47:08.582640', NULL, '2025-12-04 15:38:20.288386', 202, '12/11/2026', 599000, 699000, '', 36933, 'Mr. Hùng Nguyễn, HANU. IELTS 8.5 (Writing 8.0, Speaking 8.0), TESOL', NULL, 5, NULL, 61, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/0ac2c734-e3eb-4244-b10a-f85a7e6faf90-ielts9.png', NULL, 'Khoá họ tiếng Anh cùng TED Talks bằng phương pháp Dictation gồm 202 video của TED và TED Talks, thuộc nhiều lĩnh vực khác nhau như khoa học, văn học, lịch sử, địa lý, kinh tế ... ', '[Practical English] Luyện nghe nói tiếng Anh cùng TED Talks'),
(11, NULL, '2025-11-23 03:47:58.598309', NULL, '2025-12-04 15:35:26.509913', 663, '12/11/2026', 599000, 699000, '', 1013, 'Mr. Hùng Nguyễn, HANU. IELTS 8.5 (Writing 8.0, Speaking 8.0), TESOL', NULL, 5, NULL, 59, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/c54d5d78-ad9c-47c9-addc-28dafedd4231-ielts8.jpg', NULL, 'Học bằng flash card với hình ảnh sinh động, 20.000 câu hỏi luyện tập dưới dạng các trò chơi lý thú đảm bảo việc học hiệu quả và không nhàm chán', '[Practical English] 3600 từ vựng tiếng Anh thông dụng'),
(12, NULL, '2025-11-23 03:49:16.070604', NULL, '2025-12-04 15:30:11.383264', 248, '12/11/2026', 599000, 699000, '', 985, 'Mr. Hùng Nguyễn, HANU. IELTS 8.5 (Writing 8.0, Speaking 8.0), TESOL', NULL, 5, NULL, 49, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/266c6bbc-7347-4000-afc7-9971b9f652a9-fl8.png', NULL, 'Khóa học trình bày các ngữ pháp từ thông dụng tới nâng cao phù hợp cho sự phát triển toàn diện cho kì thi IELTS/TOEIC', '[Practical English] Ngữ pháp tiếng Anh từ A-Z'),
(13, NULL, '2025-11-23 03:50:53.923759', NULL, '2025-11-23 03:50:53.923785', 321, '12/11/2026', 599000, 699000, '', 12052, ' Ms. Thư Dương: Hơn 5 năm kinh nghiệm dạy HSK(K) - tốt nghiệp đại học Shanghai University of Political Science and Law, Thượng Hải. HSK6 + HSKK cao cấp (2019, 2024).', NULL, 6, NULL, NULL, NULL, NULL, 'Khoá học “HSK 1+2 - Tiếng Trung cơ bản” do STUDY4 biên soạn và xây dựng gồm lý thuyết, video bài giảng và video minh họa cách phát âm từ những thanh mẫu, vận mẫu, thanh điệu, biến âm cơ bản nhất', 'HSK 1+2 - Tiếng Trung cơ bản'),
(14, NULL, '2025-11-23 03:51:21.870562', NULL, '2025-12-04 15:31:13.295502', 321, '12/11/2026', 599000, 699000, '', 10266, ' Ms. Thư Dương: Hơn 5 năm kinh nghiệm dạy HSK(K) - tốt nghiệp đại học Shanghai University of Political Science and Law, Thượng Hải. HSK6 + HSKK cao cấp (2019, 2024).', NULL, 6, NULL, 50, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/62f45006-05ba-4050-be29-80b618fb80b0-hsk3.png', NULL, 'Khoá học “HSK 1+2 - Tiếng Trung cơ bản” do STUDY4 biên soạn và xây dựng gồm lý thuyết, video bài giảng và video minh họa cách phát âm từ những thanh mẫu, vận mẫu, thanh điệu, biến âm cơ bản nhất', 'Chinh phục HSK 3'),
(15, NULL, '2025-11-23 03:51:47.057234', NULL, '2025-12-04 15:31:31.114864', 224, '12/11/2026', 599000, 699000, '', 9172, ' Ms. Thư Dương: Hơn 5 năm kinh nghiệm dạy HSK(K) - tốt nghiệp đại học Shanghai University of Political Science and Law, Thượng Hải. HSK6 + HSKK cao cấp (2019, 2024).', NULL, 6, NULL, 51, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/89ae7127-e30d-4d8c-bccb-ea15b1c58ea7-hsk4.png', NULL, 'Khoá học “HSK 1+2 - Tiếng Trung cơ bản” do STUDY4 biên soạn và xây dựng gồm lý thuyết, video bài giảng và video minh họa cách phát âm từ những thanh mẫu, vận mẫu, thanh điệu, biến âm cơ bản nhất', 'Chinh phục HSK 4'),
(16, NULL, '2025-11-23 03:52:12.988031', NULL, '2025-12-04 15:31:42.153823', 257, '12/11/2026', 599000, 699000, '', 5169, ' Ms. Thư Dương: Hơn 5 năm kinh nghiệm dạy HSK(K) - tốt nghiệp đại học Shanghai University of Political Science and Law, Thượng Hải. HSK6 + HSKK cao cấp (2019, 2024).', NULL, 6, NULL, 52, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/f91c3746-7b05-4283-bbe7-6f95e8bd0863-hsk5.jpg', NULL, 'Khoá học “HSK 1+2 - Tiếng Trung cơ bản” do STUDY4 biên soạn và xây dựng gồm lý thuyết, video bài giảng và video minh họa cách phát âm từ những thanh mẫu, vận mẫu, thanh điệu, biến âm cơ bản nhất', 'Chinh phục HSK 5'),
(17, NULL, '2025-11-23 03:52:56.278668', NULL, '2025-12-04 15:32:14.932780', 281, '12/11/2026', 599000, 699000, '', 3465, ' Ms. Thư Dương: Hơn 5 năm kinh nghiệm dạy HSK(K) - tốt nghiệp đại học Shanghai University of Political Science and Law, Thượng Hải. HSK6 + HSKK cao cấp (2019, 2024).', NULL, 6, NULL, 53, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/57281c03-6618-4983-ad15-830b32f5fb56-hsk6.jpg', NULL, 'Khóa học Chinh phục HSK 6 do STUDY4 biên soạn và xây dựng gồm bài giảng dạy chi tiết các chủ điểm ngữ pháp quan trọng và tất cả các dạng câu hỏi trong từng phần thi của bài thi HSK 6', 'Chinh phục HSK 6'),
(18, NULL, NULL, NULL, '2025-12-04 15:33:08.865450', 50, '12/11/2026', 3500000, 5500000, '', 15055, 'Admin', NULL, 8, NULL, 55, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/c6f9aaf8-4606-4aa7-95ea-9a7121d92a9d-aws3.png', 0, 'Tìm hiểu về IAM, VPCs, EC2, and S3 để quản lí identity, compute and storage in AWS.Deploy application, automate deployments using CDK, CodePipeline,...', 'AWS Certified Developer Associate Specialization'),
(19, NULL, '2025-11-23 03:58:45.920370', NULL, '2025-12-04 15:33:19.818575', 50, '12/11/2026', 3500000, 5500000, '', 15055, '', NULL, 8, NULL, 56, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/2e7aae3f-b6a3-4bd1-b975-5277c50aa315-aws2.png', NULL, 'Tìm hiểu về IAM, VPCs, EC2, and S3 để quản lí identity, compute and storage in AWS.Deploy application, automate deployments using CDK, CodePipeline,...', 'AWS Flash - SaaS Technical Fundamentals'),
(21, NULL, '2025-11-25 17:24:07.826054', NULL, '2025-11-25 17:24:07.826095', 50, '12/11/2026', 35000, 5500000, '', 15055, '', NULL, 8, NULL, NULL, NULL, NULL, 'Tìm hiểu về IAM, VPCs, EC2, and S3 để quản lí identity, compute and storage in AWS.Deploy application, automate deployments using CDK, CodePipeline,...', 'AWS Flash - SaaS Technical Fundamentals Advance'),
(22, NULL, NULL, NULL, '2025-12-01 16:47:08.798686', 50, '12/11/2026', 22000, 5500000, '', 15055, 'Admin', NULL, 8, NULL, 30, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/125eca20-8acf-4f5c-9a94-46a287f851ac-aws%201.jpg', 0, 'Tìm hiểu về IAM, VPCs, EC2, and S3 để quản lí identity, compute and storage in AWS.Deploy application, automate deployments using CDK, CodePipeline,...', 'AWS Flash - SaaS Technical Fundamentals Advance2'),
(23, NULL, NULL, NULL, '2025-12-03 06:15:36.190427', 500, '12/11/2026', 20000, 15000000, '', 555, 'Dr Doom', NULL, 8, NULL, 31, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/49992b1f-309e-4b03-9347-ca99debd07f1-aws3.jpg', 6, 'aws advance3', 'AWS ADVANCE 3'),
(24, NULL, '2025-12-10 06:12:07.880322', NULL, '2025-12-10 06:12:41.998845', 250, '12/12/2027', 15000, 400000, '', 500, 'Mr Huy', NULL, 8, NULL, 62, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/0993c8a0-4469-446d-99a8-fccda875c93b-aws3.png', 100, 'AWS ADVANCE 4 ', 'AWS ADVANCE 4'),
(25, NULL, '2025-12-10 06:52:19.022157', NULL, '2025-12-10 06:52:35.848022', 0, '6', 10000, 200000, '', 0, 'a', NULL, 1, NULL, 63, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/7b1ef275-d46c-4a56-ac2f-b98556cd610f-aws2.png', 0, '', 'Bắt đầu học TIếng anh');

-- --------------------------------------------------------

--
-- Table structure for table `course_enrollments`
--

CREATE TABLE `course_enrollments` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `lesson_completed` int DEFAULT NULL,
  `completed` bit(1) DEFAULT NULL,
  `enroll_time` datetime(6) DEFAULT NULL,
  `expire_at` datetime(6) DEFAULT NULL,
  `payment_id` bigint DEFAULT NULL,
  `progress` double DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `course_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `course_enrollments`
--

INSERT INTO `course_enrollments` (`id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `lesson_completed`, `completed`, `enroll_time`, `expire_at`, `payment_id`, `progress`, `user_id`, `course_id`) VALUES
(3, NULL, NULL, NULL, NULL, NULL, NULL, '2025-11-26 01:53:28.282472', NULL, 34, NULL, 8, 21),
(4, NULL, NULL, NULL, NULL, 0, NULL, '2025-11-26 07:36:15.008754', '2026-11-26 07:36:14.965431', 35, NULL, 8, 22),
(5, NULL, NULL, NULL, NULL, 0, NULL, '2025-12-01 05:26:04.376373', '2026-12-01 05:26:04.272125', 43, NULL, 6, 22),
(6, NULL, NULL, NULL, NULL, 0, NULL, '2025-12-01 05:36:40.669252', '2026-12-01 05:36:40.666835', 44, NULL, 6, 22),
(7, NULL, NULL, NULL, NULL, 0, NULL, '2025-12-01 05:42:16.533146', '2026-12-01 05:42:16.531413', 45, NULL, 6, 22),
(8, NULL, NULL, NULL, NULL, 0, NULL, '2025-12-01 05:50:26.728821', '2026-12-01 05:50:26.727436', 46, NULL, 6, 22),
(9, NULL, NULL, NULL, NULL, 0, NULL, '2025-12-01 05:52:34.942534', '2026-12-01 05:52:34.940716', 47, NULL, 6, 22),
(10, NULL, NULL, NULL, NULL, 0, NULL, '2025-12-02 17:33:24.221925', '2026-12-02 17:33:24.033150', 48, NULL, 10, 22),
(11, NULL, NULL, NULL, NULL, 0, NULL, '2025-12-03 06:25:07.217533', '2026-12-03 06:25:07.214281', 49, NULL, 10, 23),
(12, NULL, NULL, NULL, NULL, 0, NULL, '2025-12-10 06:15:35.947120', '2026-12-10 06:15:35.930974', 50, NULL, 10, 24),
(13, NULL, NULL, NULL, NULL, 0, NULL, '2025-12-10 06:56:47.270965', '2026-12-10 06:56:47.268543', 51, NULL, 6, 25);

-- --------------------------------------------------------

--
-- Table structure for table `flashcards`
--

CREATE TABLE `flashcards` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `number_of_word` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `thumbnail_id` bigint DEFAULT NULL,
  `thumbnail_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `flashcards`
--

INSERT INTO `flashcards` (`id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `description`, `language`, `number_of_word`, `title`, `thumbnail_id`, `thumbnail_url`) VALUES
(2, NULL, '2025-11-24 08:51:32.031715', NULL, '2025-12-04 06:53:33.778212', '', 'Tiếng Anh', 536, 'Từ vựng tiếng Anh văn phòng', 36, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/a20a772a-a0b4-402b-92f9-476ee2b51f7b-fl1.jpg'),
(3, NULL, '2025-11-24 08:52:24.009148', NULL, '2025-12-04 06:55:54.311741', '', 'Tiếng Anh', 798, 'Từ vựng tiếng Anh giao tiếp trung cấp', 37, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/252c66f8-2cc2-4fa8-9670-d52bb8e9a53f-fl2.jpg'),
(4, NULL, '2025-11-24 08:52:31.277380', NULL, '2025-12-04 06:56:29.078069', '', 'Tiếng Anh', 798, 'Từ vựng tiếng Anh giao tiếp cơ bản', 38, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/c7e5fa3c-9207-41b2-a3de-b9a34fd70136-fl8.png'),
(5, NULL, '2025-11-24 08:53:09.053271', NULL, '2025-12-04 07:17:35.709786', '', 'Tiếng Anh', 899, '900 từ TOEFL', 39, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/2d325e8e-3086-4ac2-af04-8bcda19e9cc2-fl3.png'),
(6, NULL, '2025-11-24 08:53:25.591504', NULL, '2025-12-04 07:17:47.251423', '', 'Tiếng Anh', 899, '900 từ IELTS(có ảnh)', 40, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/68d09563-4bf5-4e7c-b885-e693af74cf42-fl7.png'),
(7, NULL, '2025-11-24 08:53:31.442091', NULL, '2025-12-04 07:18:47.129866', '', 'Tiếng Anh', 899, '900 từ SAT(có ảnh)', 41, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/da83979c-67bc-482e-a261-c91f5da3ddc6-fl9.png'),
(8, NULL, '2025-11-24 08:53:58.983040', NULL, '2025-12-04 07:19:21.020198', '', 'Tiếng Anh', 868, 'GRE-GMAT Vocabulary List', 42, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/f230df90-1c35-49ed-b780-991ddbb1a5a0-fl10.jpg'),
(9, NULL, '2025-11-24 08:54:18.729860', NULL, '2025-12-04 07:19:32.272863', '', 'Tiếng Anh', 868, 'New Academic Word List', 43, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/0c00a03b-53a9-4378-8cf8-cfba90565b6f-fl10.jpg'),
(10, NULL, '2025-11-24 08:54:33.967360', NULL, '2025-12-04 07:20:46.142315', '', 'Tiếng Anh', 1665, 'Business Word List', 44, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/5e2e01fa-baa3-4b1f-9d34-c564ab932082-fl11.jpg'),
(11, NULL, '2025-11-24 08:54:47.022569', NULL, '2025-12-04 07:20:56.029031', '', 'Tiếng Anh', 1665, '600 TOEIC words', 45, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/71b4ba45-cf04-4718-8cf9-15a3a59571d6-toeic%201.jpg'),
(12, NULL, '2025-11-24 08:55:04.687471', NULL, '2025-12-04 07:21:05.223323', '', 'Tiếng Anh', 1194, 'TOEIC Word List', 46, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/2b61c326-35e8-4fcd-aeb6-15003b1d3e8e-toeic%204.jpg'),
(13, NULL, '2025-11-24 08:55:26.191374', NULL, '2025-12-04 07:21:14.521144', '', 'Tiếng Anh', 1467, 'Barron\'s SAT words', 47, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/a5c85126-40fa-489d-8e4c-50d765eb3ced-fl9.png');

-- --------------------------------------------------------

--
-- Table structure for table `lessons`
--

CREATE TABLE `lessons` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `transcript` varchar(255) DEFAULT NULL,
  `video` varchar(255) DEFAULT NULL,
  `completed` bit(1) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `course_id` bigint DEFAULT NULL,
  `lesson_id` bigint DEFAULT NULL,
  `thumbnail_id` bigint DEFAULT NULL,
  `video_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `lessons`
--

INSERT INTO `lessons` (`id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `description`, `thumbnail`, `title`, `transcript`, `video`, `completed`, `user_id`, `course_id`, `lesson_id`, `thumbnail_id`, `video_id`) VALUES
(1, NULL, '2025-11-23 10:59:36.404413', NULL, '2025-11-23 10:59:36.405082', 'List 20 danh sách từ', NULL, 'Lesson 1:Từ vựng TOEIC', 'updating...', NULL, NULL, NULL, 1, NULL, NULL, NULL),
(2, NULL, '2025-11-23 11:04:43.721073', NULL, '2025-11-23 11:04:43.721102', 'Các khái niệm, cấu trúc so sánh,cấu trúc phân từ, câu điều kiện, thể ,thì , từ loại cơ bản', NULL, 'Lesson 2:Ngữ pháp', 'updating...', NULL, NULL, NULL, 1, NULL, NULL, NULL),
(3, NULL, '2025-11-23 11:06:11.768132', NULL, '2025-11-23 11:06:11.768157', 'Phân biệt tranh tả, người tả vật, cả hai và xác định đối tượng, miêu tả môi trường.', NULL, 'Lesson 3:Photographs- Nghe tranh', 'updating...', NULL, NULL, NULL, 1, NULL, NULL, NULL),
(4, NULL, '2025-11-23 11:07:23.638571', NULL, '2025-11-23 11:07:23.638592', 'Xác định loại câu hỏi ( Wh, Yes/No), câu hỏi đuôi, options, request', NULL, 'Lesson 4:Question - Response - Hỏi - đáp', 'updating...', NULL, NULL, NULL, 1, NULL, NULL, NULL),
(5, NULL, '2025-11-23 11:16:52.138738', NULL, '2025-11-23 11:16:52.138941', 'Xác định câu hỏi, chú ý keyword để bắt câu trả lời', NULL, 'Lesson 5:Conversations - Nghe hiểu đối thoại', 'updating...', NULL, NULL, NULL, 1, NULL, NULL, NULL),
(6, NULL, '2025-11-23 11:18:00.475566', NULL, '2025-11-23 11:18:00.475597', 'Xác định dạng bài(Ads, Announcement, Talk, report,) xác định câu hỏi', NULL, 'Lesson 6:Talks - Nghe hiểu bài nói', 'updating...', NULL, NULL, NULL, 1, NULL, NULL, NULL),
(7, NULL, '2025-11-23 11:19:46.830108', NULL, '2025-11-23 11:19:46.830128', 'Xác định loại từ cần điền, chú ý ngữ pháp, dạng đúng của từ.', NULL, 'Lesson 7:Incomplete Sentences -Điền từ vào câu', 'updating...', NULL, NULL, NULL, 1, NULL, NULL, NULL),
(8, NULL, '2025-11-23 11:20:51.604668', NULL, '2025-11-23 11:20:51.604698', 'Xác định ngữ cảnh đoạn văn, câu văn trước sau.', NULL, 'Lesson 8:Text Completion - Điền từ vào đoạn văn', 'updating...', NULL, NULL, NULL, 1, NULL, NULL, NULL),
(9, NULL, '2025-11-23 11:22:25.180897', NULL, '2025-11-23 11:22:25.180929', 'Dạng bài đọc: article,review, announcement,notice, Email, Letter, Form, Text Message', NULL, 'Lesson 9:Reading Comprehension', 'updating...', NULL, NULL, NULL, 1, NULL, NULL, NULL),
(10, NULL, '2025-12-01 16:35:30.407045', NULL, '2025-12-03 05:09:33.423501', 'Học viên làm học tạo tài khoản aws, làm quen với một số config, mfa cơ bản', NULL, 'Lesson1: Getting Started', NULL, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/b98a8c6a-edf9-439b-b001-57a049541c4d-PART%201%20-%20TEST%201.mp3', NULL, NULL, 22, NULL, NULL, 14),
(11, NULL, '2025-12-01 16:48:38.948591', NULL, '2025-12-03 05:09:36.477185', 'create account, mfa, unlock public access', NULL, 'aws lesson 1: getting started', NULL, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/8c7794b8-8d01-4122-9622-70cad76bd630-PART%201%20-%20TEST%202.mp3', NULL, NULL, 22, NULL, NULL, 15),
(12, NULL, '2025-12-01 16:54:38.599474', NULL, '2025-12-03 05:09:37.814159', 'create account, mfa, unlock public access', NULL, 'lesson 1 : Getting Started', NULL, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/bc960bf7-dc0a-4401-a50a-d70e287025ec-PART%201%20-%20TEST%203.mp3', NULL, NULL, 22, NULL, NULL, 16),
(13, NULL, '2025-12-03 04:59:35.322533', NULL, '2025-12-03 04:59:35.322571', 'upload file, query, delete , permission', NULL, 'Lesson 2: S3, Storage', NULL, NULL, NULL, NULL, 22, NULL, NULL, NULL),
(14, NULL, '2025-12-03 06:16:02.715086', NULL, '2025-12-03 06:23:24.757094', 'review basic knowledge', NULL, 'Lesson 1: Review', NULL, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/c85aa3b4-e958-44d3-a979-57555e0c6edf-PART%202%20-%20TEST%201.mp3', NULL, NULL, 23, NULL, NULL, 19),
(15, NULL, '2025-12-03 06:16:27.633597', NULL, '2025-12-03 06:23:23.823220', 'load balancing', NULL, 'Lesson 2: Advance 1', NULL, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/220d8011-95aa-40e4-badf-ec2f0863b813-PART%202%20-%20TEST%202.mp3', NULL, NULL, 23, NULL, NULL, 18),
(16, NULL, '2025-12-03 06:16:57.072637', NULL, '2025-12-03 06:16:57.072652', 'security', NULL, 'Lesson 3: Advance 2', NULL, NULL, NULL, NULL, 23, NULL, NULL, NULL),
(17, NULL, '2025-12-10 06:52:53.527488', NULL, '2025-12-10 07:05:19.515725', 'Lesson1', NULL, 'Lesson 1', NULL, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/4fbfcd89-facb-4333-af11-2da37c0e5a19-Test_01.mp3', NULL, NULL, 25, NULL, NULL, 33),
(18, NULL, '2025-12-10 06:54:00.370650', NULL, '2025-12-10 06:54:00.370664', 'lesson 2', NULL, 'lesson 2', NULL, NULL, NULL, NULL, 25, NULL, NULL, NULL),
(19, NULL, '2025-12-10 06:54:16.703089', NULL, '2025-12-10 06:54:16.703127', 'Lesson 3', NULL, 'Lesson 3', NULL, NULL, NULL, NULL, 25, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE `subjects` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `name`) VALUES
(1, NULL, '2025-11-17 10:12:34.208995', NULL, '2025-11-17 10:12:34.209054', 'TOEIC'),
(2, NULL, '2025-11-17 10:15:30.471704', NULL, '2025-11-17 10:15:30.471737', 'IELTS Academic'),
(3, NULL, '2025-11-17 10:15:46.491779', NULL, '2025-11-17 10:15:46.491799', 'IELTS General'),
(4, NULL, '2025-11-17 10:16:03.668742', NULL, '2025-11-17 10:16:03.668803', 'IELTS Writing and Speaking'),
(5, NULL, '2025-11-17 10:16:19.531747', NULL, '2025-11-17 10:16:19.531776', 'Basic English'),
(6, NULL, '2025-11-17 10:16:28.423505', NULL, '2025-11-17 10:16:28.423530', 'HSK'),
(8, NULL, '2025-11-22 17:22:27.863148', NULL, '2025-11-22 17:22:27.863193', 'AWS'),
(9, NULL, '2025-12-02 10:03:06.668622', NULL, '2025-12-02 10:03:06.668680', 'Japan N1');

-- --------------------------------------------------------

--
-- Table structure for table `words`
--

CREATE TABLE `words` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `audio_link` varchar(255) DEFAULT NULL,
  `definition` varchar(255) DEFAULT NULL,
  `phonetic` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `type_of_text` varchar(255) DEFAULT NULL,
  `flashcard_id` bigint DEFAULT NULL,
  `audio_id` bigint DEFAULT NULL,
  `image_id` bigint DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `audio` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `words`
--

INSERT INTO `words` (`id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `audio_link`, `definition`, `phonetic`, `text`, `type_of_text`, `flashcard_id`, `audio_id`, `image_id`, `image_url`, `audio`) VALUES
(1, NULL, '2025-11-24 09:36:58.147103', NULL, '2025-12-10 04:57:46.560088', NULL, 'Correct and without any mistakes.', '/ˈæk.jər.ət/', 'accurate', 'adjective', 9, 32, NULL, NULL, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/fef32e05-c96e-44b2-a671-679bf5a5a9d4-word-1.webm'),
(2, NULL, '2025-11-24 09:37:20.228864', NULL, '2025-11-24 09:37:20.228877', NULL, 'To think about something carefully.', '/kənˈsɪd.ər/', 'consider', 'verb', 9, NULL, NULL, NULL, NULL),
(3, NULL, '2025-11-24 09:37:33.799445', NULL, '2025-11-24 09:37:33.799453', NULL, 'To say or do something as a reaction to something.', '/rɪˈspɒnd/', 'respond', 'verb', 9, NULL, NULL, NULL, NULL),
(4, NULL, '2025-11-24 09:37:53.360682', NULL, '2025-11-24 09:37:53.360733', NULL, 'To need something or make something necessary.', '/rɪˈkwaɪər/', 'require', 'verb', 9, NULL, NULL, NULL, NULL),
(5, NULL, '2025-11-24 09:38:16.717787', NULL, '2025-11-24 09:38:16.717797', NULL, 'Working well and effectively without wasting time or resources.', '/ɪˈfɪʃ.ənt/', 'efficient', 'adjective', 9, NULL, NULL, NULL, NULL),
(6, NULL, '2025-11-24 09:38:53.501189', NULL, '2025-11-24 09:38:53.501199', NULL, 'A particular time or event.', '/əˈkeɪ.ʒən/', 'occasion', 'noun', 9, NULL, NULL, NULL, NULL),
(7, NULL, '2025-11-24 09:39:09.939441', NULL, '2025-11-24 09:39:09.939451', NULL, 'To buy something.', '/ˈpɜː.tʃəs/', 'purchase', 'verb', 9, NULL, NULL, NULL, NULL),
(8, NULL, '2025-11-24 09:39:22.067600', NULL, '2025-11-24 09:39:22.067629', NULL, 'To make something known publicly.', '/əˈnaʊns/', 'announce', 'verb', 9, NULL, NULL, NULL, NULL),
(9, NULL, '2025-11-24 09:39:36.988448', NULL, '2025-11-24 09:39:36.988465', NULL, 'Able to be used or obtained.', '/əˈveɪ.lə.bəl/', 'available', 'adjective', 9, NULL, NULL, NULL, NULL),
(10, NULL, '2025-11-24 09:40:17.402864', NULL, '2025-11-24 09:40:17.402873', NULL, 'To make something smaller or less in amount.', '/rɪˈdjuːs/', 'reduce', 'verb', 9, NULL, NULL, NULL, NULL),
(11, NULL, '2025-11-24 09:43:16.213846', NULL, '2025-11-24 09:43:16.213910', NULL, 'A place where aircraft take off and land.', '/ˈeə.pɔːt/', 'airport', 'noun', 9, NULL, NULL, NULL, NULL),
(12, NULL, '2025-11-24 09:43:41.138693', NULL, '2025-11-24 09:43:41.138703', NULL, 'A vehicle with two wheels that you ride by pushing pedals.', '/ˈbaɪ.sɪ.kəl/', 'bicycle', 'noun', 9, NULL, NULL, NULL, NULL),
(13, NULL, '2025-11-24 09:52:31.067931', NULL, '2025-11-24 09:52:31.067984', NULL, 'An electronic machine used for processing information.', '/kəmˈpjuː.tər/', 'computer', 'noun', 9, NULL, NULL, NULL, NULL),
(14, NULL, '2025-12-04 15:47:14.919774', NULL, '2025-12-04 15:55:13.728886', NULL, 'place where people work', '/ˈɑː.fɪs/', 'office', 'noun', 2, 20, NULL, NULL, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/c5a25a61-8c68-47fe-970a-ad0cb003d0c8-word-14.webm'),
(15, NULL, '2025-12-04 15:49:36.965686', NULL, '2025-12-04 15:56:38.650615', NULL, 'people who work at the same office', '/ˈkɑː.liːɡ/', 'colleague', 'noun', 2, 21, NULL, NULL, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/6d10e635-09e8-4482-b353-3012fa0407ce-word-15.webm'),
(16, NULL, '2025-12-04 15:51:04.397440', NULL, '2025-12-04 15:57:02.785162', NULL, 'a planned gathering of people to discuss something', '/ˈmiː.tɪŋ/', 'meeting', 'noun', 2, 22, NULL, NULL, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/4dcc7ea4-8484-4505-b076-68f3d9f13855-word-16.webm'),
(17, NULL, '2025-12-04 15:51:36.376995', NULL, '2025-12-04 15:57:15.552892', NULL, 'scheduled meeting or arrangement', '/əˈpɔɪnt.mənt/', 'appointment', 'noun', 2, 23, NULL, NULL, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/671b2b44-7df3-4acd-9c20-b7a93c2ceda7-word-17.webm'),
(18, NULL, '2025-12-04 15:52:01.128673', NULL, '2025-12-04 15:57:27.242272', NULL, 'a plan that show when tasks or events will happen', '/ˈʃedʒ.uːl/', 'schedule', 'noun', 2, 24, NULL, NULL, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/5cc919ff-e70e-4521-8e24-7baf9b0bcad6-word-18.webm'),
(19, NULL, '2025-12-04 15:52:37.387505', NULL, '2025-12-04 15:57:52.722979', NULL, 'a written or printed piece of information', '/ˈdɒk.jʊ.mənt/', 'document', 'noun', 2, 25, NULL, NULL, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/a5c52299-dbd3-428f-af6e-c1c9229870d5-word-19.webm'),
(20, NULL, '2025-12-04 15:53:02.608457', NULL, '2025-12-04 15:58:20.021115', NULL, 'a person who manages or oversees others', '/ˈsuː.pə.vaɪ.zər/', 'supervisor', 'noun', 2, 26, NULL, NULL, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/a431a29e-daaa-4208-b620-bd3ed77c2e5e-word-20.webm'),
(21, NULL, '2025-12-04 15:53:25.609765', NULL, '2025-12-04 15:58:33.796748', NULL, 'the final time when something must be completed', '/ˈded.laɪn/', 'deadline', 'noun', 2, 28, NULL, NULL, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/06cb3d80-0a7b-4139-bd9a-93526e03c426-word-21.webm'),
(22, NULL, '2025-12-04 15:53:45.691029', NULL, '2025-12-04 15:59:00.792294', NULL, 'the area where a person works', '/ˈwɜːk.speɪs/', 'workspace', 'noun', 2, 29, NULL, NULL, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/c772a72b-daca-4448-b89d-88b8ca46c950-word-22.webm'),
(23, NULL, '2025-12-04 15:54:11.444683', NULL, '2025-12-04 15:59:09.730095', NULL, 'a machine that prints documents', '/ˈprɪn.tər/', 'printer', 'noun', 2, 30, NULL, NULL, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/115d1928-233e-41fa-8d38-2da01dd5e6fd-word-23.webm'),
(24, NULL, '2025-12-10 06:57:57.101751', NULL, '2025-12-10 06:57:57.101795', NULL, 'â', '', 'a', 'noun', 2, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blogs`
--
ALTER TABLE `blogs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKc38boyqklhkixihg7fhk20kqr` (`category_id`);

--
-- Indexes for table `blog_category`
--
ALTER TABLE `blog_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5tckdihu5akp5nkxiacx1gfhi` (`subject_id`);

--
-- Indexes for table `course_enrollments`
--
ALTER TABLE `course_enrollments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf78cq7ecdpk1clt1w5ofnb34t` (`course_id`);

--
-- Indexes for table `flashcards`
--
ALTER TABLE `flashcards`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lessons`
--
ALTER TABLE `lessons`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK17ucc7gjfjddsyi0gvstkqeat` (`course_id`),
  ADD KEY `FK2rjx8teigne84ibsbmra35pcy` (`lesson_id`);

--
-- Indexes for table `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `words`
--
ALTER TABLE `words`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlncp0u66xdn06yuowa7dsq2hu` (`flashcard_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blogs`
--
ALTER TABLE `blogs`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `blog_category`
--
ALTER TABLE `blog_category`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `course_enrollments`
--
ALTER TABLE `course_enrollments`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `flashcards`
--
ALTER TABLE `flashcards`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `lessons`
--
ALTER TABLE `lessons`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `subjects`
--
ALTER TABLE `subjects`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `words`
--
ALTER TABLE `words`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `blogs`
--
ALTER TABLE `blogs`
  ADD CONSTRAINT `FKc38boyqklhkixihg7fhk20kqr` FOREIGN KEY (`category_id`) REFERENCES `blog_category` (`id`);

--
-- Constraints for table `courses`
--
ALTER TABLE `courses`
  ADD CONSTRAINT `FK5tckdihu5akp5nkxiacx1gfhi` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`);

--
-- Constraints for table `course_enrollments`
--
ALTER TABLE `course_enrollments`
  ADD CONSTRAINT `FKf78cq7ecdpk1clt1w5ofnb34t` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`);

--
-- Constraints for table `lessons`
--
ALTER TABLE `lessons`
  ADD CONSTRAINT `FK17ucc7gjfjddsyi0gvstkqeat` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`),
  ADD CONSTRAINT `FK2rjx8teigne84ibsbmra35pcy` FOREIGN KEY (`lesson_id`) REFERENCES `lessons` (`id`);

--
-- Constraints for table `words`
--
ALTER TABLE `words`
  ADD CONSTRAINT `FKlncp0u66xdn06yuowa7dsq2hu` FOREIGN KEY (`flashcard_id`) REFERENCES `flashcards` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
