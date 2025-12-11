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
-- Database: `study5_learning`
--

-- --------------------------------------------------------

--
-- Table structure for table `exams`
--

CREATE TABLE `exams` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `number_of_completion` int DEFAULT NULL,
  `number_of_question` int DEFAULT NULL,
  `part` int DEFAULT NULL,
  `term` varchar(255) DEFAULT NULL,
  `thumbnail_id` bigint DEFAULT NULL,
  `thumbnail_url` varchar(255) DEFAULT NULL,
  `time` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `audio_id` bigint DEFAULT NULL,
  `audio_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `exams`
--

INSERT INTO `exams` (`id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `info`, `number_of_completion`, `number_of_question`, `part`, `term`, `thumbnail_id`, `thumbnail_url`, `time`, `title`, `type`, `category_id`, `audio_id`, `audio_url`) VALUES
(1, NULL, NULL, NULL, '2025-11-29 09:19:08.467586', '', NULL, 200, 7, NULL, NULL, NULL, 120, 'New Economy TOEIC Test 1', 'OPTIONS', 7, NULL, NULL),
(2, NULL, '2025-11-29 09:21:47.777757', NULL, '2025-11-30 07:06:27.723394', '', NULL, 200, 7, NULL, 27, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/e25e09ba-83f7-4049-a6a3-dad7846b85e3-toeic_1_1.webp', 120, 'New Economy TOEIC Test 2', 'OPTIONS', 7, 2, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/6ae4b306-736f-42c9-9861-87cff2972c89-Test_01.mp3'),
(3, NULL, '2025-11-29 09:21:55.226473', NULL, '2025-11-29 09:21:55.226492', '', NULL, 200, 7, NULL, NULL, NULL, 120, 'New Economy TOEIC Test 3', 'OPTIONS', 7, NULL, NULL),
(4, NULL, '2025-11-29 09:22:01.141562', NULL, '2025-11-29 09:22:01.141587', '', NULL, 200, 7, NULL, NULL, NULL, 120, 'New Economy TOEIC Test 4', 'OPTIONS', 7, NULL, NULL),
(5, NULL, '2025-11-29 09:22:06.741194', NULL, '2025-11-29 09:22:06.741215', '', NULL, 200, 7, NULL, NULL, NULL, 120, 'New Economy TOEIC Test 5', 'OPTIONS', 7, NULL, NULL),
(6, NULL, '2025-11-29 09:22:12.888021', NULL, '2025-11-29 09:22:12.888035', '', NULL, 200, 7, NULL, NULL, NULL, 120, 'New Economy TOEIC Test 6', 'OPTIONS', 7, NULL, NULL),
(7, NULL, '2025-11-29 09:22:16.473354', NULL, '2025-11-29 09:22:16.473391', '', NULL, 200, 7, NULL, NULL, NULL, 120, 'New Economy TOEIC Test 7', 'OPTIONS', 7, NULL, NULL),
(8, NULL, '2025-11-29 09:22:27.437229', NULL, '2025-11-29 09:22:27.437251', '', NULL, 200, 7, NULL, NULL, NULL, 120, 'New Economy TOEIC Test 8', 'OPTIONS', 7, NULL, NULL),
(9, NULL, '2025-11-29 09:22:30.854339', NULL, '2025-11-29 09:22:30.854357', '', NULL, 200, 7, NULL, NULL, NULL, 120, 'New Economy TOEIC Test 9', 'OPTIONS', 7, NULL, NULL),
(10, NULL, '2025-11-29 09:22:34.424517', NULL, '2025-12-03 04:19:28.322426', '', NULL, 200, 7, NULL, NULL, NULL, 120, 'New Economy TOEIC Test 10', 'OPTIONS', 7, 9, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/31b5e2ae-72ef-4dd0-bbe3-10d4498e134a-PART%201%20-%20TEST%201.mp3'),
(11, NULL, '2025-11-29 09:22:48.614600', NULL, '2025-11-29 09:22:48.614662', '', NULL, 200, 7, NULL, NULL, NULL, 120, 'Longman TOEIC (old format) Test 1', 'OPTIONS', 7, NULL, NULL),
(12, NULL, '2025-11-29 09:22:51.717104', NULL, '2025-11-29 09:22:51.717135', '', NULL, 200, 7, NULL, NULL, NULL, 120, 'Longman TOEIC (old format) Test 2', 'OPTIONS', 7, NULL, NULL),
(13, NULL, '2025-11-29 09:22:54.071025', NULL, '2025-11-29 09:22:54.071065', '', NULL, 200, 7, NULL, NULL, NULL, 120, 'Longman TOEIC (old format) Test 3', 'OPTIONS', 7, NULL, NULL),
(14, NULL, '2025-11-29 09:22:57.212927', NULL, '2025-11-29 09:22:57.212963', '', NULL, 200, 7, NULL, NULL, NULL, 120, 'Longman TOEIC (old format) Test 4', 'OPTIONS', 7, NULL, NULL),
(15, NULL, '2025-11-29 09:22:59.825879', NULL, '2025-11-29 09:22:59.825897', '', NULL, 200, 7, NULL, NULL, NULL, 120, 'Longman TOEIC (old format) Test 5', 'OPTIONS', 7, NULL, NULL),
(16, NULL, '2025-11-29 09:23:02.997510', NULL, '2025-11-29 09:23:02.997536', '', NULL, 200, 7, NULL, NULL, NULL, 120, 'Longman TOEIC (old format) Test 6', 'OPTIONS', 7, NULL, NULL),
(17, NULL, '2025-11-29 09:23:58.503375', NULL, '2025-11-29 09:23:58.503393', '', NULL, 40, 4, NULL, NULL, NULL, 40, 'IELTS Simulation Listening test 1', 'OPTIONS', 5, NULL, NULL),
(18, NULL, '2025-11-29 09:24:12.215148', NULL, '2025-11-29 09:24:12.215186', '', NULL, 40, 4, NULL, NULL, NULL, 40, 'IELTS Simulation Listening test 2', 'OPTIONS', 5, NULL, NULL),
(19, NULL, '2025-11-29 09:24:14.994422', NULL, '2025-11-29 09:24:14.994455', '', NULL, 40, 4, NULL, NULL, NULL, 40, 'IELTS Simulation Listening test 3', 'OPTIONS', 5, NULL, NULL),
(20, NULL, '2025-11-29 09:24:17.096899', NULL, '2025-11-29 09:24:17.096924', '', NULL, 40, 4, NULL, NULL, NULL, 40, 'IELTS Simulation Listening test 4', 'OPTIONS', 5, NULL, NULL),
(21, NULL, '2025-11-29 09:24:18.865885', NULL, '2025-11-29 09:24:18.865935', '', NULL, 40, 4, NULL, NULL, NULL, 40, 'IELTS Simulation Listening test 5', 'OPTIONS', 5, NULL, NULL),
(22, NULL, '2025-11-29 09:24:21.060144', NULL, '2025-11-29 09:24:21.060172', '', NULL, 40, 4, NULL, NULL, NULL, 40, 'IELTS Simulation Listening test 6', 'OPTIONS', 5, NULL, NULL),
(23, NULL, '2025-11-29 09:24:23.479080', NULL, '2025-11-29 09:24:23.479113', '', NULL, 40, 4, NULL, NULL, NULL, 40, 'IELTS Simulation Listening test 7', 'OPTIONS', 5, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `exam_attempts`
--

CREATE TABLE `exam_attempts` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `completed` bit(1) DEFAULT NULL,
  `duration_sec` int DEFAULT NULL,
  `end_at` datetime(6) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `start_at` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_correct` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `exam_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `exam_attempts`
--

INSERT INTO `exam_attempts` (`id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `completed`, `duration_sec`, `end_at`, `score`, `start_at`, `status`, `total_correct`, `user_id`, `exam_id`) VALUES
(1, NULL, '2025-11-29 09:53:00.239183', NULL, '2025-11-29 09:53:00.239229', NULL, NULL, NULL, NULL, '2025-11-29 09:53:00.158959', 'PENDING', NULL, 8, 1);

-- --------------------------------------------------------

--
-- Table structure for table `exam_category`
--

CREATE TABLE `exam_category` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `exam_category`
--

INSERT INTO `exam_category` (`id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `content`) VALUES
(5, NULL, '2025-11-28 06:56:23.518904', NULL, '2025-11-28 06:56:23.518947', 'IELTS Academic'),
(6, NULL, '2025-11-28 06:56:52.358447', NULL, '2025-11-28 06:56:52.358473', 'IELTS General'),
(7, NULL, '2025-11-28 06:57:01.802913', NULL, '2025-11-28 06:57:01.802946', 'Toeic'),
(8, NULL, '2025-11-28 06:57:16.790543', NULL, '2025-11-28 06:57:16.790568', 'Toeic SW'),
(9, NULL, '2025-11-28 06:57:40.896412', NULL, '2025-11-28 06:57:40.896455', 'HSK 1'),
(10, NULL, '2025-11-28 06:58:00.838272', NULL, '2025-11-28 06:58:00.838390', 'HSK 2'),
(11, NULL, '2025-11-28 06:58:15.395420', NULL, '2025-11-28 06:58:15.395450', 'HSK 3'),
(12, NULL, '2025-11-28 06:58:33.826070', NULL, '2025-11-28 06:58:33.826094', 'HSK 4'),
(13, NULL, '2025-11-28 06:58:56.266171', NULL, '2025-11-28 06:58:56.266239', 'HSK 5'),
(14, NULL, '2025-11-28 07:01:16.294821', NULL, '2025-11-28 07:01:16.294856', 'TOPIK I'),
(15, NULL, '2025-11-28 07:15:15.714187', NULL, '2025-11-28 07:15:15.714225', 'TOPIK II'),
(16, NULL, '2025-11-28 07:15:29.041388', NULL, '2025-11-28 07:15:29.041414', 'N5'),
(17, NULL, '2025-11-28 07:15:34.356018', NULL, '2025-11-28 07:15:34.356076', 'N4'),
(18, NULL, '2025-11-28 07:15:38.897953', NULL, '2025-11-28 07:15:38.897979', 'N3'),
(19, NULL, '2025-11-28 07:15:43.461654', NULL, '2025-11-28 07:15:43.461734', 'N2'),
(20, NULL, '2025-11-28 07:15:51.010014', NULL, '2025-11-28 07:15:51.010054', 'N1'),
(21, NULL, '2025-11-28 07:16:02.567677', NULL, '2025-11-28 07:16:02.567698', 'Digital SAT'),
(22, NULL, '2025-11-28 07:17:01.975597', NULL, '2025-11-28 07:17:01.975619', 'Tiếng Anh THPTQG'),
(23, NULL, '2025-11-28 07:17:08.181498', NULL, '2025-11-28 07:17:08.181524', 'Toán THPTQG'),
(24, NULL, '2025-11-28 07:17:12.972862', NULL, '2025-11-28 07:17:12.972912', 'Vật lý THPTQG'),
(25, NULL, '2025-11-28 07:17:18.609669', NULL, '2025-11-28 07:17:18.609691', 'Hóa học THPTQG'),
(26, NULL, '2025-11-28 07:17:23.310549', NULL, '2025-11-28 07:17:23.310622', 'Sinh học THPTQG'),
(27, NULL, '2025-11-28 07:17:27.995815', NULL, '2025-11-28 07:17:27.995838', 'ACT'),
(28, NULL, '2025-11-28 07:17:55.565661', NULL, '2025-11-28 07:17:55.565696', 'AWS General'),
(29, NULL, '2025-11-28 07:18:04.492059', NULL, '2025-11-28 07:18:04.492085', 'AWS Advance');

-- --------------------------------------------------------

--
-- Table structure for table `exam_results`
--

CREATE TABLE `exam_results` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `chosen_answer` varchar(255) DEFAULT NULL,
  `exam_attempt_id` bigint DEFAULT NULL,
  `question_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `answera` varchar(255) DEFAULT NULL,
  `answerb` varchar(255) DEFAULT NULL,
  `answerc` varchar(255) DEFAULT NULL,
  `answerd` varchar(255) DEFAULT NULL,
  `audio` varchar(255) DEFAULT NULL,
  `audio_id` bigint DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `correct_answer` varchar(255) DEFAULT NULL,
  `detailed_explanation` varchar(255) DEFAULT NULL,
  `difficulty_level` varchar(255) DEFAULT NULL,
  `image_id` bigint DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `script` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `transcript` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `exam_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `answera`, `answerb`, `answerc`, `answerd`, `audio`, `audio_id`, `category`, `correct_answer`, `detailed_explanation`, `difficulty_level`, `image_id`, `image_url`, `question`, `script`, `status`, `transcript`, `type`, `exam_id`) VALUES
(1, NULL, '2025-11-29 09:32:24.743355', NULL, '2025-11-30 05:51:57.936568', 'She is typing on a keyboard.', 'She is writing on a whiteboard.', 'She is speaking on the phone.', 'She is carrying boxes.', NULL, NULL, 'Part 1', 'A', 'Bức tranh mô tả người phụ nữ đang gõ bàn phím máy tính → đáp án A.', 'EASY', 22, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/d4123b6a-34ac-4f9e-ad5d-bd0d7ebd1348-q1.jpg', 'What is the woman doing?', 'Look at the picture.', 'ACTIVE', '', 'SINGLE_CHOICE', 1),
(2, NULL, '2025-11-29 09:32:54.863307', NULL, '2025-11-30 05:53:12.355771', 'In a meeting room', 'In a kitchen', 'At a bus stop', 'In a classroom', NULL, NULL, 'Part 1', 'A', 'Hình ảnh cho thấy họ ngồi quanh bàn họp → đáp án A.', 'EASY', 24, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/244a5ac3-4266-4f39-95b6-cfc31c9055b1-q3.jpg', 'Where are the people?', 'Look at the picture.', 'ACTIVE', '', 'SINGLE_CHOICE', 1),
(3, NULL, '2025-11-29 09:33:04.717098', NULL, '2025-11-30 05:57:26.638751', 'Yes, I already called them.', 'It’s two blocks down the street.', 'I paid the fee yesterday.', 'Around 4 p.m.', NULL, NULL, 'Part 2', 'B', 'Câu hỏi địa điểm → câu trả lời B phù hợp.', 'EASY', 25, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/383e4e43-11d5-4b35-b46b-9f06f4116584-q3.jpg', 'Where is the nearest bank?', '', 'ACTIVE', '', 'SINGLE_CHOICE', 1),
(4, NULL, '2025-11-29 09:33:12.200955', NULL, '2025-11-30 05:58:29.459459', 'At the main office.', 'Yes, I\'ll send it today.', 'Mr. Taylor will.', 'It was approved yesterday.', NULL, NULL, 'Part 2', 'C', 'Câu hỏi \'Who\' → cần người → đáp án C.', 'EASY', 26, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/a6fd5fa7-8533-4921-a4c9-7c53118b6893-q4.jpg', 'Who will present the sales report today?', '', 'ACTIVE', '', 'SINGLE_CHOICE', 1),
(5, NULL, '2025-11-29 09:33:21.111140', NULL, '2025-11-29 09:33:21.111158', 'Because I had another meeting.', 'Yes, it starts at noon.', 'In the conference hall.', 'I’ll check the schedule.', NULL, NULL, 'Part 2', 'A', 'Câu hỏi Why → đáp án A là lý do hợp lý.', 'MEDIUM', NULL, NULL, 'Why didn\'t you attend the workshop?', '', 'ACTIVE', '', 'SINGLE_CHOICE', 1),
(6, NULL, '2025-11-29 09:33:30.348620', NULL, '2025-11-29 09:33:30.348650', 'Sure, I’ll email it right away.', 'I think it\'s on the third floor.', 'No, it closes early.', 'About 10 pages long.', NULL, NULL, 'Part 2', 'A', 'Yêu cầu gửi file → đáp án A phù hợp.', 'EASY', NULL, NULL, 'Could you send me the updated file?', '', 'ACTIVE', '', 'SINGLE_CHOICE', 1),
(7, NULL, '2025-11-29 09:33:38.848535', NULL, '2025-11-29 09:33:38.848565', 'Book a hotel room.', 'Finish his presentation.', 'Cancel his flight.', 'Register for the conference.', NULL, NULL, 'Part 3', 'B', 'Người đàn ông nói trực tiếp \'need to finish my presentation\' → đáp án B.', 'EASY', NULL, NULL, 'What does the man say he needs to do?', 'W: Are you going to the conference next week?\nM: Yes, but I still need to finish my presentation.', 'ACTIVE', 'The man says he needs to finish his presentation for the conference.', 'LISTENING_COMPREHENSION', 1),
(8, NULL, '2025-11-29 09:33:48.215822', NULL, '2025-11-29 09:33:48.215848', 'The printer is broken.', 'The lights are off.', 'The room is locked.', 'The Wi-Fi is slow.', NULL, NULL, 'Part 3', 'A', 'Người đàn ông nói máy in không hoạt động → đáp án A.', 'EASY', NULL, NULL, 'What problem is mentioned?', 'M: The printer on the second floor isn’t working.\nW: I’ll call the technician.', 'ACTIVE', 'The man mentions the printer is not working.', 'LISTENING_COMPREHENSION', 1),
(9, NULL, '2025-11-29 09:33:55.839121', NULL, '2025-11-29 09:33:55.839181', 'Apply for a membership.', 'Visit the store on Saturday.', 'Ask for a refund.', 'Cancel his order.', NULL, NULL, 'Part 3', 'B', 'Ông ấy nói \'I’ll come on Saturday\' → đáp án B.', 'MEDIUM', NULL, NULL, 'What does the man plan to do?', 'W: We’re offering a 20% discount this weekend.\nM: Great, I’ll come on Saturday.', 'ACTIVE', 'The man says he will come on Saturday for the discount.', 'LISTENING_COMPREHENSION', 1),
(10, NULL, '2025-11-29 09:34:08.146002', NULL, '2025-11-29 09:34:08.146033', 'She thinks it\'s too expensive.', 'She didn’t like the service.', 'She enjoyed the coffee.', 'She hasn\'t visited it yet.', NULL, NULL, 'Part 3', 'C', '“The coffee was excellent” → nghĩa là cô ấy thích → đáp án C.', 'EASY', NULL, NULL, 'What does the woman think of the café?', 'M: Did you see the new café on Oak Street?\nW: Yes, I tried it yesterday. The coffee was excellent.', 'ACTIVE', 'The woman says the coffee was excellent.', 'LISTENING_COMPREHENSION', 1),
(11, NULL, '2025-11-29 09:34:30.457874', NULL, '2025-11-29 09:34:30.457958', 'Press 1', 'Press 2', 'Wait for an operator', 'Visit the website', NULL, NULL, 'Part 4', 'A', '“To make a reservation, press 1” → đáp án A.', 'EASY', NULL, NULL, 'What should callers do to make a reservation?', 'Thank you for calling Sunlight Hotel. To make a reservation, press 1. For customer service, press 2.', 'ACTIVE', 'The system says to press 1 for reservations.', 'ANNOUNCEMENT', 1),
(12, NULL, '2025-11-29 09:34:37.996020', NULL, '2025-11-29 09:34:37.996047', 'Tomorrow morning', 'Today at 3 p.m.', 'Tomorrow at 3 p.m.', 'Next week', NULL, NULL, 'Part 4', 'C', 'Thông báo nói rõ \'3 p.m. tomorrow\' → đáp án C.', 'EASY', NULL, NULL, 'When is the appointment?', 'Good afternoon. This is a reminder that your appointment with Dr. Lewis is scheduled for 3 p.m. tomorrow.', 'ACTIVE', 'The message states the appointment is at 3 p.m. tomorrow.', 'ANNOUNCEMENT', 1),
(13, NULL, '2025-11-29 09:35:13.853103', NULL, '2025-11-29 09:35:13.853127', 'Canceling the meeting', 'Moving the meeting to Friday', 'Changing to a different location', 'Inviting more people', NULL, NULL, 'Part 3', 'B', 'Cả hai đều đồng ý Friday works better → đáp án B.', 'MEDIUM', NULL, NULL, 'What do the speakers agree on?', 'W: I think we should move the meeting to Friday.\nM: That works better for me, too.', 'ACTIVE', 'They agree that Friday is a better day for the meeting.', 'LISTENING_COMPREHENSION', 1),
(14, NULL, '2025-11-29 09:35:20.960077', NULL, '2025-11-29 09:35:20.960135', 'Print another report', 'Call a client', 'Review the report', 'Go to lunch early', NULL, NULL, 'Part 3', 'C', 'Cô ấy nói \'I\'ll review it\' → đáp án C.', 'EASY', NULL, NULL, 'What will the woman do next?', 'M: The report you requested is on your desk.\nW: Oh, great! I\'ll review it before lunch.', 'ACTIVE', 'She says she will review the report before lunch.', 'LISTENING_COMPREHENSION', 1),
(15, NULL, '2025-11-29 09:35:29.287754', NULL, '2025-11-29 09:35:29.287771', 'Immediately', 'In five minutes', 'In one hour', 'Tonight', NULL, NULL, 'Part 4', 'B', '‘Arrive in five minutes’ → đáp án B.', 'EASY', NULL, NULL, 'When will the train arrive?', 'The next train to Central Station will arrive in five minutes.', 'ACTIVE', 'The announcement states the train will arrive in five minutes.', 'ANNOUNCEMENT', 1),
(16, NULL, '2025-11-29 09:35:36.633567', NULL, '2025-11-29 09:35:36.633590', 'The park was full.', 'The weather was bad.', 'The food was not ready.', 'There were no volunteers.', NULL, NULL, 'Part 4', 'B', 'Nội dung nêu rõ bad weather → đáp án B.', 'EASY', NULL, NULL, 'Why was the picnic moved indoors?', 'Our company picnic has been moved indoors due to bad weather.', 'ACTIVE', 'It was moved indoors because of bad weather.', 'ANNOUNCEMENT', 1),
(17, NULL, '2025-11-29 09:35:43.747034', NULL, '2025-11-29 09:35:43.747081', 'Take a training class', 'Submit their reports', 'Work extra hours', 'Move to another office', NULL, NULL, 'Part 4', 'B', 'Thông báo yêu cầu submit reports → đáp án B.', 'MEDIUM', NULL, NULL, 'What must employees do?', 'Attention employees: Please submit your monthly reports by Friday at noon.', 'ACTIVE', 'Employees must submit monthly reports by Friday at noon.', 'ANNOUNCEMENT', 1),
(18, NULL, '2025-11-29 09:35:50.671332', NULL, '2025-11-29 09:35:50.671354', 'Taking photos', 'Entering the museum', 'Using flash when taking photos', 'Asking for information', NULL, NULL, 'Part 4', 'C', 'Thông báo cấm dùng flash → đáp án C.', 'EASY', NULL, NULL, 'What is NOT allowed according to the announcement?', 'Welcome to the City Art Museum. Photography is allowed, but please do not use flash.', 'ACTIVE', 'Photography is allowed but flash is not allowed.', 'ANNOUNCEMENT', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `exams`
--
ALTER TABLE `exams`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsqpr6f0m2yt2ue3cqi3scxfv` (`category_id`);

--
-- Indexes for table `exam_attempts`
--
ALTER TABLE `exam_attempts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5tomiinihc09ywy0wh15pi2cs` (`exam_id`);

--
-- Indexes for table `exam_category`
--
ALTER TABLE `exam_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `exam_results`
--
ALTER TABLE `exam_results`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKp1x3y7vc787aljfb5f2ndlbel` (`exam_attempt_id`),
  ADD KEY `FKklosng87se4pls64o667gbrp0` (`question_id`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrk78bmt53fns7np8casqa3q44` (`exam_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `exams`
--
ALTER TABLE `exams`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `exam_attempts`
--
ALTER TABLE `exam_attempts`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `exam_category`
--
ALTER TABLE `exam_category`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `exam_results`
--
ALTER TABLE `exam_results`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `exams`
--
ALTER TABLE `exams`
  ADD CONSTRAINT `FKsqpr6f0m2yt2ue3cqi3scxfv` FOREIGN KEY (`category_id`) REFERENCES `exam_category` (`id`);

--
-- Constraints for table `exam_attempts`
--
ALTER TABLE `exam_attempts`
  ADD CONSTRAINT `FK5tomiinihc09ywy0wh15pi2cs` FOREIGN KEY (`exam_id`) REFERENCES `exams` (`id`);

--
-- Constraints for table `exam_results`
--
ALTER TABLE `exam_results`
  ADD CONSTRAINT `FKklosng87se4pls64o667gbrp0` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`),
  ADD CONSTRAINT `FKp1x3y7vc787aljfb5f2ndlbel` FOREIGN KEY (`exam_attempt_id`) REFERENCES `exam_attempts` (`id`);

--
-- Constraints for table `questions`
--
ALTER TABLE `questions`
  ADD CONSTRAINT `FKrk78bmt53fns7np8casqa3q44` FOREIGN KEY (`exam_id`) REFERENCES `exams` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
