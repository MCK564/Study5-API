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
-- Database: `study5_upload`
--

-- --------------------------------------------------------

--
-- Table structure for table `audios`
--

CREATE TABLE `audios` (
  `id` bigint NOT NULL,
  `belong_to_id` bigint DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quality` varchar(255) DEFAULT NULL,
  `size` bigint DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `belong_to_object` varchar(255) DEFAULT NULL,
  `media_kind` varchar(255) DEFAULT NULL,
  `media_owner_type` varchar(255) DEFAULT NULL,
  `media_usage` varchar(255) DEFAULT NULL
) ;

--
-- Dumping data for table `audios`
--

INSERT INTO `audios` (`id`, `belong_to_id`, `description`, `name`, `quality`, `size`, `url`, `created_by`, `created_date`, `modified_by`, `modified_date`, `belong_to_object`, `media_kind`, `media_owner_type`, `media_usage`) VALUES
(1, 2, NULL, 'Exam 1 Audio', NULL, 44109018, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/af88749a-21d8-4388-ba56-9dae62aabda6-Test_01.mp3', NULL, '2025-11-30 06:57:14.618807', NULL, '2025-11-30 06:57:14.618896', 'EXAM_AUDIO', 'AUDIO', NULL, NULL),
(2, 2, NULL, 'Exam 1 Audio', NULL, 44109018, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/6ae4b306-736f-42c9-9861-87cff2972c89-Test_01.mp3', NULL, '2025-11-30 07:06:26.802628', NULL, '2025-11-30 07:06:26.802649', 'EXAM_AUDIO', 'AUDIO', NULL, NULL),
(3, 11, NULL, 'audio lesson 11', NULL, 2836938, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/f83bd640-5e20-40fb-806a-2e88f4dea523-PART%201%20-%20TEST%201.mp3', NULL, '2025-12-02 11:31:14.053004', NULL, '2025-12-02 11:31:14.053601', 'LESSON_AUDIO', 'AUDIO', NULL, NULL),
(4, 12, NULL, 'audio lesson 12', NULL, 44109018, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/b93af1f4-c2ed-499e-bcbd-602295891a23-Test_01.mp3', NULL, '2025-12-02 16:18:09.661608', NULL, '2025-12-02 16:18:09.661763', 'LESSON_AUDIO', 'AUDIO', NULL, NULL),
(5, 12, NULL, 'audio lesson 12', NULL, 2836938, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/86d7a129-be00-4458-83ec-36a9a8f53df7-PART%201%20-%20TEST%201.mp3', NULL, '2025-12-02 16:21:45.554951', NULL, '2025-12-02 16:21:45.554968', 'LESSON_AUDIO', 'AUDIO', NULL, NULL),
(6, 12, NULL, 'audio lesson 12', NULL, 2836938, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/9a5908c0-920a-4ddd-83b9-a6d46149c173-PART%201%20-%20TEST%201.mp3', NULL, '2025-12-02 17:11:31.682146', NULL, '2025-12-02 17:11:31.682302', 'LESSON_AUDIO', 'AUDIO', NULL, NULL),
(7, 12, NULL, 'audio lesson 12', NULL, 2836938, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/01b69200-98fc-47f7-9110-ffb16e35d1c2-PART%201%20-%20TEST%201.mp3', NULL, '2025-12-02 18:15:48.911469', NULL, '2025-12-02 18:15:48.911532', 'LESSON_AUDIO', 'AUDIO', NULL, NULL),
(8, 12, NULL, 'audio lesson 12', NULL, 2836938, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/054a1678-0310-4176-b500-a96749bad36c-PART%201%20-%20TEST%201.mp3', NULL, '2025-12-02 18:26:13.621113', NULL, '2025-12-02 18:26:13.621233', 'LESSON_AUDIO', 'AUDIO', NULL, NULL),
(9, 10, NULL, 'audio lesson 10', NULL, 2836938, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/31b5e2ae-72ef-4dd0-bbe3-10d4498e134a-PART%201%20-%20TEST%201.mp3', NULL, '2025-12-03 04:19:25.983894', NULL, '2025-12-03 04:19:25.983925', 'LESSON_AUDIO', 'AUDIO', NULL, NULL),
(12, 10, NULL, 'audio lesson 10', NULL, 2836938, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/a85d286f-02fb-4d37-a0eb-0c8ac0d06d16-PART%201%20-%20TEST%201.mp3', NULL, '2025-12-03 04:56:31.081097', NULL, '2025-12-03 04:56:31.081122', 'LESSON_AUDIO', 'AUDIO', NULL, NULL),
(13, 11, NULL, 'audio lesson 11', NULL, 2761878, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/1fdd5800-79db-4f06-89ac-f87c4656d1cf-PART%201%20-%20TEST%202.mp3', NULL, '2025-12-03 04:56:38.161032', NULL, '2025-12-03 04:56:38.161053', 'LESSON_AUDIO', 'AUDIO', NULL, NULL),
(14, 10, NULL, 'audio lesson 10', NULL, 2836938, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/b98a8c6a-edf9-439b-b001-57a049541c4d-PART%201%20-%20TEST%201.mp3', NULL, '2025-12-03 05:09:32.466165', NULL, '2025-12-03 05:09:32.466188', 'LESSON_AUDIO', 'AUDIO', NULL, NULL),
(15, 11, NULL, 'audio lesson 11', NULL, 2761878, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/8c7794b8-8d01-4122-9622-70cad76bd630-PART%201%20-%20TEST%202.mp3', NULL, '2025-12-03 05:09:36.356972', NULL, '2025-12-03 05:09:36.357004', 'LESSON_AUDIO', 'AUDIO', NULL, NULL),
(16, 12, NULL, 'audio lesson 12', NULL, 2704749, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/bc960bf7-dc0a-4401-a50a-d70e287025ec-PART%201%20-%20TEST%203.mp3', NULL, '2025-12-03 05:09:37.762451', NULL, '2025-12-03 05:09:37.762473', 'LESSON_AUDIO', 'AUDIO', NULL, NULL),
(17, 1, NULL, 'word-1.webm', NULL, 45698, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/e94f0340-3486-47a9-9a07-ff8c0028b552-word-1.webm', NULL, '2025-12-03 05:40:23.219845', NULL, '2025-12-03 05:40:23.219865', 'WORD', 'AUDIO', NULL, NULL),
(18, 15, NULL, 'audio lesson 15', NULL, 8592789, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/220d8011-95aa-40e4-badf-ec2f0863b813-PART%202%20-%20TEST%202.mp3', NULL, '2025-12-03 06:23:23.728263', NULL, '2025-12-03 06:23:23.728281', 'LESSON_AUDIO', 'AUDIO', NULL, NULL),
(19, 14, NULL, 'audio lesson 14', NULL, 8634489, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/c85aa3b4-e958-44d3-a979-57555e0c6edf-PART%202%20-%20TEST%201.mp3', NULL, '2025-12-03 06:23:24.727450', NULL, '2025-12-03 06:23:24.727464', 'LESSON_AUDIO', 'AUDIO', NULL, NULL),
(20, 14, NULL, 'word-14.webm', NULL, 39902, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/c5a25a61-8c68-47fe-970a-ad0cb003d0c8-word-14.webm', NULL, '2025-12-04 15:55:13.269021', NULL, '2025-12-04 15:55:13.269144', 'WORD_AUDIO', 'AUDIO', NULL, NULL),
(21, 15, NULL, 'word-15.webm', NULL, 22514, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/6d10e635-09e8-4482-b353-3012fa0407ce-word-15.webm', NULL, '2025-12-04 15:56:38.572332', NULL, '2025-12-04 15:56:38.572338', 'WORD_AUDIO', 'AUDIO', NULL, NULL),
(22, 16, NULL, 'word-16.webm', NULL, 25412, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/4dcc7ea4-8484-4505-b076-68f3d9f13855-word-16.webm', NULL, '2025-12-04 15:57:02.724331', NULL, '2025-12-04 15:57:02.724341', 'WORD_AUDIO', 'AUDIO', NULL, NULL),
(23, 17, NULL, 'word-17.webm', NULL, 30242, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/671b2b44-7df3-4acd-9c20-b7a93c2ceda7-word-17.webm', NULL, '2025-12-04 15:57:15.503439', NULL, '2025-12-04 15:57:15.503448', 'WORD_AUDIO', 'AUDIO', NULL, NULL),
(24, 18, NULL, 'word-18.webm', NULL, 27344, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/5cc919ff-e70e-4521-8e24-7baf9b0bcad6-word-18.webm', NULL, '2025-12-04 15:57:27.173553', NULL, '2025-12-04 15:57:27.173561', 'WORD_AUDIO', 'AUDIO', NULL, NULL),
(25, 19, NULL, 'word-19.webm', NULL, 31208, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/a5c52299-dbd3-428f-af6e-c1c9229870d5-word-19.webm', NULL, '2025-12-04 15:57:52.680277', NULL, '2025-12-04 15:57:52.680297', 'WORD_AUDIO', 'AUDIO', NULL, NULL),
(26, 20, NULL, 'word-20.webm', NULL, 17684, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/a431a29e-daaa-4208-b620-bd3ed77c2e5e-word-20.webm', NULL, '2025-12-04 15:58:19.973723', NULL, '2025-12-04 15:58:19.973731', 'WORD_AUDIO', 'AUDIO', NULL, NULL),
(27, 21, NULL, 'word-21.webm', NULL, 35072, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/e534c691-5a66-431d-9db9-0f1581122f10-word-21.webm', NULL, '2025-12-04 15:58:26.076137', NULL, '2025-12-04 15:58:26.076181', 'WORD_AUDIO', 'AUDIO', NULL, NULL),
(28, 21, NULL, 'word-21.webm', NULL, 35072, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/06cb3d80-0a7b-4139-bd9a-93526e03c426-word-21.webm', NULL, '2025-12-04 15:58:33.764384', NULL, '2025-12-04 15:58:33.764395', 'WORD_AUDIO', 'AUDIO', NULL, NULL),
(29, 22, NULL, 'word-22.webm', NULL, 33140, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/c772a72b-daca-4448-b89d-88b8ca46c950-word-22.webm', NULL, '2025-12-04 15:59:00.739320', NULL, '2025-12-04 15:59:00.739331', 'WORD_AUDIO', 'AUDIO', NULL, NULL),
(30, 23, NULL, 'word-23.webm', NULL, 39902, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/115d1928-233e-41fa-8d38-2da01dd5e6fd-word-23.webm', NULL, '2025-12-04 15:59:09.649880', NULL, '2025-12-04 15:59:09.649887', 'WORD_AUDIO', 'AUDIO', NULL, NULL),
(31, 1, NULL, 'word-1.webm', NULL, 27344, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/1c491568-2f5a-47a6-bd6b-998c48ddc798-word-1.webm', NULL, '2025-12-10 04:56:57.300463', NULL, '2025-12-10 04:56:57.300566', 'WORD_AUDIO', 'AUDIO', NULL, NULL),
(32, 1, NULL, 'word-1.webm', NULL, 40868, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/fef32e05-c96e-44b2-a671-679bf5a5a9d4-word-1.webm', NULL, '2025-12-10 04:57:46.467500', NULL, '2025-12-10 04:57:46.467531', 'WORD_AUDIO', 'AUDIO', NULL, NULL),
(33, 17, NULL, 'audio lesson 17', NULL, 44109018, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/audios/4fbfcd89-facb-4333-af11-2da37c0e5a19-Test_01.mp3', NULL, '2025-12-10 07:05:19.448594', NULL, '2025-12-10 07:05:19.448626', 'LESSON_AUDIO', 'AUDIO', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE `images` (
  `id` bigint NOT NULL,
  `belong_to_id` bigint DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quality` varchar(255) DEFAULT NULL,
  `size` bigint DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `belong_to_object` varchar(255) DEFAULT NULL,
  `media_kind` varchar(255) DEFAULT NULL,
  `media_owner_type` varchar(255) DEFAULT NULL,
  `media_usage` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `images`
--

INSERT INTO `images` (`id`, `belong_to_id`, `name`, `quality`, `size`, `url`, `created_by`, `created_date`, `modified_by`, `modified_date`, `description`, `belong_to_object`, `media_kind`, `media_owner_type`, `media_usage`) VALUES
(1, NULL, 'avatar cua user 1', 'ORIGINAL', NULL, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/c7081042-ac0c-43b1-aed0-05a0a32d61cd-1.jpg', NULL, '2025-11-11 04:46:55.346865', NULL, '2025-11-11 04:46:55.346909', NULL, NULL, NULL, NULL, NULL),
(2, NULL, 'avatar cua user 1', 'ORIGINAL', 13610, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/fef4b78a-cd08-48e4-bebc-9e9d4ecc0c67-2.jpg', NULL, '2025-11-16 04:19:02.577810', NULL, '2025-11-16 04:19:02.577831', NULL, NULL, 'IMAGE', NULL, NULL),
(3, NULL, 'avatar cua user 1', 'ORIGINAL', 13610, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/11da11ba-fbd7-458e-bf3a-5b972e586b79-2.jpg', NULL, '2025-11-16 06:28:48.395152', NULL, '2025-11-16 06:28:48.395193', NULL, NULL, 'IMAGE', NULL, NULL),
(4, NULL, 'avatar cua user 1', 'ORIGINAL', 13610, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/0998549d-f133-4788-b741-67d4681c4656-2.jpg', NULL, '2025-11-16 06:38:59.151938', NULL, '2025-11-16 06:38:59.151951', NULL, NULL, 'IMAGE', NULL, NULL),
(5, 6, 'avatar cua user 1', 'ORIGINAL', 13610, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/ffbb1a77-74ba-4f1a-9432-c5e57cfaae4a-2.jpg', NULL, '2025-11-16 06:52:12.234459', NULL, '2025-11-16 06:52:12.234467', NULL, 'AVATAR', 'IMAGE', NULL, NULL),
(6, 6, 'avatar cua user 1', 'ORIGINAL', 13610, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/081d65a0-8882-4612-8d3f-108f7eed1f84-2.jpg', NULL, '2025-11-16 07:06:30.235919', NULL, '2025-11-16 07:06:30.236111', NULL, 'AVATAR', 'IMAGE', NULL, NULL),
(7, 6, 'avatar cua user 1', 'ORIGINAL', 13610, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/4f10583d-cc95-412c-9aa2-3155e3bb6de3-2.jpg', NULL, '2025-11-16 07:09:38.814970', NULL, '2025-11-16 07:09:38.814977', NULL, 'USER', 'IMAGE', NULL, NULL),
(8, 6, 'avatar cua user 1', 'ORIGINAL', 13610, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/f213b4a8-34d8-4b7f-9a39-e3c12b0c96d5-2.jpg', NULL, '2025-11-16 07:58:30.125999', NULL, '2025-11-16 07:58:30.126035', NULL, 'USER', 'IMAGE', 'USER', 'AVATAR'),
(9, 6, 'avatar cua user 1', 'ORIGINAL', 13610, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/c84b5999-d9d1-4ca6-ab6f-e3bd1118eade-2.jpg', NULL, '2025-11-16 09:53:49.516343', NULL, '2025-11-16 09:53:49.516408', NULL, 'USER', 'IMAGE', 'USER', 'AVATAR'),
(10, 6, 'avatar cua user 1', 'ORIGINAL', 13610, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/8263a527-3965-4479-9e3f-35dd46363c3f-2.jpg', NULL, '2025-11-16 09:57:59.745249', NULL, '2025-11-16 09:57:59.745269', NULL, 'USER', 'IMAGE', 'USER', 'AVATAR'),
(11, 6, 'avatar cua user 1', 'ORIGINAL', 13610, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/204f7377-c2ad-4cf1-afd5-78dd3abec150-2.jpg', NULL, '2025-11-16 09:59:38.231630', NULL, '2025-11-16 09:59:38.231649', NULL, 'USER', 'IMAGE', 'USER', 'AVATAR'),
(12, 6, 'avatar cua user 1', 'ORIGINAL', 13610, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/1b1707f9-29dd-4406-aa8a-aa977f010727-2.jpg', NULL, '2025-11-16 10:09:56.103729', NULL, '2025-11-16 10:09:56.103769', NULL, 'USER_AVATAR', 'IMAGE', 'USER', 'AVATAR'),
(13, 6, 'avatar cua user 1', 'ORIGINAL', 13610, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/6e91da98-89b9-4dc3-b41d-006bd8192fd2-2.jpg', NULL, '2025-11-16 10:32:27.633645', NULL, '2025-11-16 10:32:27.633661', NULL, 'USER_BANNER', 'IMAGE', 'USER', 'AVATAR'),
(14, 7, 'avatar cua user 7', 'ORIGINAL', 13610, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/0f94575c-31ca-4390-bf65-22da448b8b2b-2.jpg', NULL, '2025-11-21 17:55:42.648347', NULL, '2025-11-21 17:55:42.648407', NULL, 'USER_BANNER', 'IMAGE', 'USER', 'AVATAR'),
(15, 6, 'avatarrrrr', NULL, 6352, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/58c31a9e-81f3-4633-89c5-3636a016c2d6-cat.jpg', NULL, '2025-11-21 18:12:23.215255', NULL, '2025-11-21 18:12:23.215328', NULL, 'USER_AVATAR', 'IMAGE', 'USER', 'AVATAR'),
(16, 4, 'Thumbnail của course số 4', NULL, 19068, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/a4c05877-6d8b-47a5-a35d-24acd61172fd-toeic_1_1.webp', NULL, '2025-11-23 17:44:11.549467', NULL, '2025-11-23 17:44:11.549502', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(17, 4, 'Thumbnail của course số 4', NULL, 19068, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/74c72ad2-8eec-4240-9d19-dcb4bc778415-toeic_1_1.webp', NULL, '2025-11-24 03:12:47.384159', NULL, '2025-11-24 03:12:47.384210', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(18, 4, 'Thumbnail của course số 4', NULL, 19068, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/0d0587cc-41cd-4b20-b54c-2c37877e2f15-toeic_1_1.webp', NULL, '2025-11-24 05:41:29.903594', NULL, '2025-11-24 05:41:29.903650', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(19, 4, 'Thumbnail của course số 4', NULL, 19068, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/83238cc7-31e2-470f-8a66-3a5f3a5af223-toeic_1_1.webp', NULL, '2025-11-24 07:30:21.781774', NULL, '2025-11-24 07:30:21.781912', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(20, 3, 'thumbnail của  blog id = 3', NULL, 19068, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/f3c10f8d-a1ad-428a-aecd-ab2885e0690f-toeic_1_1.webp', NULL, '2025-11-24 08:45:47.346847', NULL, '2025-11-24 08:45:47.346916', NULL, 'BLOG_IMAGE', 'IMAGE', 'BLOG', 'THUMBNAIL'),
(21, 1, 'question id = 1 content', '', 8350, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/5e2e51c6-716d-41e5-b189-94e6487ac7d9-q1.jpg', NULL, '2025-11-29 10:05:16.764162', NULL, '2025-11-29 10:05:16.764274', NULL, 'QUESTION_IMAGE', 'IMAGE', 'QUESTION', 'CONTENT'),
(22, 1, 'question id = 1 content', '', 8350, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/d4123b6a-34ac-4f9e-ad5d-bd0d7ebd1348-q1.jpg', NULL, '2025-11-30 05:51:54.982085', NULL, '2025-11-30 05:51:54.982156', NULL, 'QUESTION_IMAGE', 'IMAGE', 'QUESTION', 'CONTENT'),
(23, 2, 'question id = 2 content', '', 7847, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/7564b8cc-bf50-477c-afce-234cf14ce7c0-q2.jpg', NULL, '2025-11-30 05:52:33.593430', NULL, '2025-11-30 05:52:33.593448', NULL, 'QUESTION_IMAGE', 'IMAGE', 'QUESTION', 'CONTENT'),
(24, 2, 'question id = 3 content', '', 6682, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/244a5ac3-4266-4f39-95b6-cfc31c9055b1-q3.jpg', NULL, '2025-11-30 05:53:12.301759', NULL, '2025-11-30 05:53:12.301792', NULL, 'QUESTION_IMAGE', 'IMAGE', 'QUESTION', 'CONTENT'),
(25, 3, 'question id = 3 content', '', 6682, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/383e4e43-11d5-4b35-b46b-9f06f4116584-q3.jpg', NULL, '2025-11-30 05:57:26.568216', NULL, '2025-11-30 05:57:26.568233', NULL, 'QUESTION_IMAGE', 'IMAGE', 'QUESTION', 'CONTENT'),
(26, 4, 'question id = 4 content', '', 7237, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/a6fd5fa7-8533-4921-a4c9-7c53118b6893-q4.jpg', NULL, '2025-11-30 05:58:29.389544', NULL, '2025-11-30 05:58:29.389566', NULL, 'QUESTION_IMAGE', 'IMAGE', 'QUESTION', 'CONTENT'),
(27, 2, 'thumbnail của  EXAM id = 2', NULL, 19068, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/e25e09ba-83f7-4049-a6a3-dad7846b85e3-toeic_1_1.webp', NULL, '2025-11-30 06:58:54.738212', NULL, '2025-11-30 06:58:54.738244', NULL, 'EXAM_IMAGE', 'IMAGE', 'EXAM', 'THUMBNAIL'),
(28, 6, 'dog.jpg', NULL, 5883, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/4d12ccdf-71de-45e6-aae7-9c4661c690ed-dog.jpg', NULL, '2025-12-01 02:33:48.121176', NULL, '2025-12-01 02:33:48.121275', NULL, 'avatar', 'IMAGE', NULL, NULL),
(29, 6, 'maldives-and-sea-holiday-hd-iyidzfb55r4ajji4.jpg', NULL, 393757, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/7c75bea3-8533-403c-b84d-6b93384ae698-maldives-and-sea-holiday-hd-iyidzfb55r4ajji4.jpg', NULL, '2025-12-01 02:34:12.594382', NULL, '2025-12-01 02:34:12.594402', NULL, 'banner', 'IMAGE', NULL, NULL),
(30, 22, 'thumbnail course id=22', NULL, 11842, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/125eca20-8acf-4f5c-9a94-46a287f851ac-aws%201.jpg', NULL, '2025-12-01 16:47:06.528534', NULL, '2025-12-01 16:47:06.528594', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(31, 23, 'thumbnail course id=23', NULL, 5693, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/49992b1f-309e-4b03-9347-ca99debd07f1-aws3.jpg', NULL, '2025-12-03 06:15:33.110518', NULL, '2025-12-03 06:15:33.111006', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(32, 6, 'dog.jpg', NULL, 5883, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/1281ac2d-a1ac-4398-817f-f42f9954e52e-dog.jpg', NULL, '2025-12-03 06:51:45.244833', NULL, '2025-12-03 06:51:45.244847', NULL, 'avatar', 'IMAGE', NULL, NULL),
(33, 1, 'thumbnail course id=1', NULL, 7885, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/93846345-ef42-4f01-b7bb-38cb7adeedd5-toeic%201.jpg', NULL, '2025-12-03 08:02:09.223755', NULL, '2025-12-03 08:02:09.223777', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(34, 5, 'thumbnail course id=5', NULL, 3553, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/8ee51a5a-07f7-4521-9b5f-15b4fbdfdc2e-ielts%203.png', NULL, '2025-12-03 08:02:52.902230', NULL, '2025-12-03 08:02:52.902246', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(35, 6, 'thumbnail course id=6', NULL, 3036, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/c13fcc25-76b3-44c9-83a6-d75b97827064-ielts%205.png', NULL, '2025-12-03 08:03:11.337469', NULL, '2025-12-03 08:03:11.337486', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(36, 2, 'flashcard-2-thumbnail', NULL, 12995, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/a20a772a-a0b4-402b-92f9-476ee2b51f7b-fl1.jpg', NULL, '2025-12-04 06:53:30.840371', NULL, '2025-12-04 06:53:30.840461', NULL, 'FLASHCARD', 'IMAGE', 'FLASHCARD', 'THUMBNAIL'),
(37, 3, 'flashcard-3-thumbnail', NULL, 16626, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/252c66f8-2cc2-4fa8-9670-d52bb8e9a53f-fl2.jpg', NULL, '2025-12-04 06:55:54.259228', NULL, '2025-12-04 06:55:54.259245', NULL, 'FLASHCARD', 'IMAGE', 'FLASHCARD', 'THUMBNAIL'),
(38, 4, 'flashcard-4-thumbnail', NULL, 9493, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/c7e5fa3c-9207-41b2-a3de-b9a34fd70136-fl8.png', NULL, '2025-12-04 06:56:29.002711', NULL, '2025-12-04 06:56:29.002860', NULL, 'FLASHCARD', 'IMAGE', 'FLASHCARD', 'THUMBNAIL'),
(39, 5, 'flashcard-5-thumbnail', NULL, 7268, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/2d325e8e-3086-4ac2-af04-8bcda19e9cc2-fl3.png', NULL, '2025-12-04 07:17:35.629081', NULL, '2025-12-04 07:17:35.629098', NULL, 'FLASHCARD', 'IMAGE', 'FLASHCARD', 'THUMBNAIL'),
(40, 6, 'flashcard-6-thumbnail', NULL, 3553, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/68d09563-4bf5-4e7c-b885-e693af74cf42-fl7.png', NULL, '2025-12-04 07:17:47.208373', NULL, '2025-12-04 07:17:47.208391', NULL, 'FLASHCARD', 'IMAGE', 'FLASHCARD', 'THUMBNAIL'),
(41, 7, 'flashcard-7-thumbnail', NULL, 2494, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/da83979c-67bc-482e-a261-c91f5da3ddc6-fl9.png', NULL, '2025-12-04 07:18:47.094780', NULL, '2025-12-04 07:18:47.094804', NULL, 'FLASHCARD', 'IMAGE', 'FLASHCARD', 'THUMBNAIL'),
(42, 8, 'flashcard-8-thumbnail', NULL, 11810, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/f230df90-1c35-49ed-b780-991ddbb1a5a0-fl10.jpg', NULL, '2025-12-04 07:19:20.969751', NULL, '2025-12-04 07:19:20.969772', NULL, 'FLASHCARD', 'IMAGE', 'FLASHCARD', 'THUMBNAIL'),
(43, 9, 'flashcard-9-thumbnail', NULL, 11810, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/0c00a03b-53a9-4378-8cf8-cfba90565b6f-fl10.jpg', NULL, '2025-12-04 07:19:32.233181', NULL, '2025-12-04 07:19:32.233197', NULL, 'FLASHCARD', 'IMAGE', 'FLASHCARD', 'THUMBNAIL'),
(44, 10, 'flashcard-10-thumbnail', NULL, 11637, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/5e2e01fa-baa3-4b1f-9d34-c564ab932082-fl11.jpg', NULL, '2025-12-04 07:20:46.104623', NULL, '2025-12-04 07:20:46.104648', NULL, 'FLASHCARD', 'IMAGE', 'FLASHCARD', 'THUMBNAIL'),
(45, 11, 'flashcard-11-thumbnail', NULL, 7885, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/71b4ba45-cf04-4718-8cf9-15a3a59571d6-toeic%201.jpg', NULL, '2025-12-04 07:20:55.996759', NULL, '2025-12-04 07:20:55.996779', NULL, 'FLASHCARD', 'IMAGE', 'FLASHCARD', 'THUMBNAIL'),
(46, 12, 'flashcard-12-thumbnail', NULL, 7579, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/2b61c326-35e8-4fcd-aeb6-15003b1d3e8e-toeic%204.jpg', NULL, '2025-12-04 07:21:05.195544', NULL, '2025-12-04 07:21:05.195560', NULL, 'FLASHCARD', 'IMAGE', 'FLASHCARD', 'THUMBNAIL'),
(47, 13, 'flashcard-13-thumbnail', NULL, 2494, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/a5c85126-40fa-489d-8e4c-50d765eb3ced-fl9.png', NULL, '2025-12-04 07:21:14.455148', NULL, '2025-12-04 07:21:14.455211', NULL, 'FLASHCARD', 'IMAGE', 'FLASHCARD', 'THUMBNAIL'),
(48, 8, 'thumbnail course id=8', NULL, 8491, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/702a99d0-7809-4f6c-9639-4451dfdc9b86-ielts%206.png', NULL, '2025-12-04 15:29:54.379087', NULL, '2025-12-04 15:29:54.379342', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(49, 12, 'thumbnail course id=12', NULL, 9493, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/266c6bbc-7347-4000-afc7-9971b9f652a9-fl8.png', NULL, '2025-12-04 15:30:11.325859', NULL, '2025-12-04 15:30:11.325868', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(50, 14, 'thumbnail course id=14', NULL, 2444, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/62f45006-05ba-4050-be29-80b618fb80b0-hsk3.png', NULL, '2025-12-04 15:31:13.247785', NULL, '2025-12-04 15:31:13.247799', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(51, 15, 'thumbnail course id=15', NULL, 5810, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/89ae7127-e30d-4d8c-bccb-ea15b1c58ea7-hsk4.png', NULL, '2025-12-04 15:31:31.055295', NULL, '2025-12-04 15:31:31.055324', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(52, 16, 'thumbnail course id=16', NULL, 5112, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/f91c3746-7b05-4283-bbe7-6f95e8bd0863-hsk5.jpg', NULL, '2025-12-04 15:31:42.115131', NULL, '2025-12-04 15:31:42.115142', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(53, 17, 'thumbnail course id=17', NULL, 4972, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/57281c03-6618-4983-ad15-830b32f5fb56-hsk6.jpg', NULL, '2025-12-04 15:32:14.884026', NULL, '2025-12-04 15:32:14.884038', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(54, 18, 'thumbnail course id=18', NULL, 13222, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/b0ee5f37-ffe0-44a2-ab70-a7fe866858fe-aws%202.jpg', NULL, '2025-12-04 15:32:33.875950', NULL, '2025-12-04 15:32:33.875964', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(55, 18, 'thumbnail course id=18', NULL, 2445, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/c6f9aaf8-4606-4aa7-95ea-9a7121d92a9d-aws3.png', NULL, '2025-12-04 15:33:08.836079', NULL, '2025-12-04 15:33:08.836088', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(56, 19, 'thumbnail course id=19', NULL, 5261, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/2e7aae3f-b6a3-4bd1-b975-5277c50aa315-aws2.png', NULL, '2025-12-04 15:33:19.791557', NULL, '2025-12-04 15:33:19.791569', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(57, 7, 'thumbnail course id=7', NULL, 3553, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/a2d640b6-617d-476a-a3c5-acb782ab140a-ielts%203.png', NULL, '2025-12-04 15:34:14.656694', NULL, '2025-12-04 15:34:14.656706', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(58, 7, 'thumbnail course id=7', NULL, 6137, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/4ea9a94a-062c-4c8c-84c3-03f831ee4164-ielts7.png', NULL, '2025-12-04 15:34:48.038758', NULL, '2025-12-04 15:34:48.038768', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(59, 11, 'thumbnail course id=11', NULL, 11337, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/c54d5d78-ad9c-47c9-addc-28dafedd4231-ielts8.jpg', NULL, '2025-12-04 15:35:26.486189', NULL, '2025-12-04 15:35:26.486197', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(60, 9, 'thumbnail course id=9', NULL, 6137, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/ada809c8-9fe8-4df7-a493-f3ea37bca42d-ielts7.png', NULL, '2025-12-04 15:36:36.782567', NULL, '2025-12-04 15:36:36.782604', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(61, 10, 'thumbnail course id=10', NULL, 6553, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/0ac2c734-e3eb-4244-b10a-f85a7e6faf90-ielts9.png', NULL, '2025-12-04 15:38:20.175601', NULL, '2025-12-04 15:38:20.175642', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(62, 24, 'thumbnail course id=24', NULL, 2445, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/0993c8a0-4469-446d-99a8-fccda875c93b-aws3.png', NULL, '2025-12-10 06:12:41.221952', NULL, '2025-12-10 06:12:41.221972', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL'),
(63, 25, 'thumbnail course id=25', NULL, 5261, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/7b1ef275-d46c-4a56-ac2f-b98556cd610f-aws2.png', NULL, '2025-12-10 06:52:35.605887', NULL, '2025-12-10 06:52:35.605908', NULL, 'COURSE_IMAGE', 'IMAGE', 'COURSE', 'THUMBNAIL');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `audios`
--
ALTER TABLE `audios`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `audios`
--
ALTER TABLE `audios`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `images`
--
ALTER TABLE `images`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
