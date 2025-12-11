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
-- Database: `study5_user`
--

-- --------------------------------------------------------

--
-- Table structure for table `schedules`
--

CREATE TABLE `schedules` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `schedules`
--

INSERT INTO `schedules` (`id`, `description`, `title`, `user_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`) VALUES
(1, 'Lịch ôn tập Toeic LR', '6 tháng AIM 750 TOEIC', 6, NULL, '2025-11-22 05:42:27.533061', NULL, '2025-11-22 05:42:27.533089', 'true'),
(2, 'Lịch làm quen với tiếng Trung', '3 tháng HSK 1', 6, NULL, '2025-11-22 05:43:03.914285', NULL, '2025-11-22 05:43:03.914310', 'true');

-- --------------------------------------------------------

--
-- Table structure for table `tasks`
--

CREATE TABLE `tasks` (
  `id` bigint NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `todo_list_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tasks`
--

INSERT INTO `tasks` (`id`, `content`, `todo_list_id`) VALUES
(1, 'Học 10 new vocabs', 2),
(2, 'Tập trung bắt keyword', 2),
(3, 'Phân tích các câu hỏi của đề', 2),
(4, 'Đọc câu hỏi trước, làm trước các đâu dễ, làm câu toàn cục sau', 3),
(5, 'Canh thời gian hợp lí cho từng part', 3);

-- --------------------------------------------------------

--
-- Table structure for table `todo_lists`
--

CREATE TABLE `todo_lists` (
  `id` bigint NOT NULL,
  `implemented_day` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `schedule_id` bigint DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `todo_lists`
--

INSERT INTO `todo_lists` (`id`, `implemented_day`, `status`, `type`, `schedule_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `title`) VALUES
(2, '2,4,6', 1, 'WEEKDAYS', 1, NULL, '2025-11-22 09:20:34.111162', NULL, '2025-11-22 09:20:34.111175', 'Luyện Listening Part 1-4'),
(3, '3,5,7', 1, 'WEEKDAYS', 1, NULL, '2025-11-22 09:21:10.668770', NULL, '2025-11-22 09:21:10.668777', 'Luyện Reading Part 5-7');

-- --------------------------------------------------------

--
-- Table structure for table `training_history`
--

CREATE TABLE `training_history` (
  `id` bigint NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `exam_name` varchar(255) DEFAULT NULL,
  `link_to_detail` varchar(255) DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  `training_amount` varchar(255) DEFAULT NULL,
  `training_type` tinyint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `exam_id` bigint DEFAULT NULL
) ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `banner` varchar(255) DEFAULT NULL,
  `courses` varbinary(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fog` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `avatar_id` bigint DEFAULT NULL,
  `banner_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `avatar`, `banner`, `courses`, `email`, `fog`, `name`, `status`, `created_by`, `created_date`, `modified_by`, `modified_date`, `address`, `phone`, `avatar_id`, `banner_id`) VALUES
(6, 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/58c31a9e-81f3-4633-89c5-3636a016c2d6-cat.jpg', 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/6e91da98-89b9-4dc3-b41d-006bd8192fd2-2.jpg', NULL, 'chikha13122@gmail.com', NULL, 'Chí Kha', b'1', NULL, '2025-11-15 08:14:19.029693', NULL, '2025-11-22 05:37:59.439432', '123, Nguyen Hue street, ward 1, Ho Chi Minh City', '0333279377', 15, 13),
(7, 'https://lh3.googleusercontent.com/a/ACg8ocIIvftZrkZ_s96kLw9k1OYfY9kXY3G0uhTAcO4Savyfx0DQoQ=s96-c', 'https://amzn-s3-study5-bucket.s3.amazonaws.com/images/0f94575c-31ca-4390-bf65-22da448b8b2b-2.jpg', NULL, 'khamai05767@gmail.com', NULL, 'Chí Kha', b'1', NULL, '2025-11-21 17:44:00.798931', NULL, '2025-11-21 17:55:44.836556', NULL, NULL, NULL, 14),
(9, 'https://lh3.googleusercontent.com/a/ACg8ocJ2D5yzXUSUA9_9-dHSgpP6Fpcxzh0GkhAsltNUbxZawGEp3cI=s96-c', NULL, NULL, '522h0113@student.tdtu.edu.vn', NULL, 'Lê Nguyễn Hoàng Yến', b'1', NULL, '2025-12-02 17:01:34.351743', NULL, '2025-12-02 17:01:34.352567', NULL, NULL, NULL, NULL),
(10, 'https://lh3.googleusercontent.com/a/ACg8ocL7KdRa_UrxV470Ictoti1-FeD2KISVNpsXPLSStRmPsAzjkQ=s96-c', NULL, NULL, '52200050@student.tdtu.edu.vn', NULL, 'Mai Chí Kha', b'1', NULL, '2025-12-02 17:07:34.004740', NULL, '2025-12-02 17:07:34.004762', NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `schedules`
--
ALTER TABLE `schedules`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKd4y4xekwahv9boo6lc8gfl3jv` (`user_id`);

--
-- Indexes for table `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8csrtw05jkes3eoauc9b23q5g` (`todo_list_id`);

--
-- Indexes for table `todo_lists`
--
ALTER TABLE `todo_lists`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmcbclfxid1om8c1ofver4ye2b` (`schedule_id`);

--
-- Indexes for table `training_history`
--
ALTER TABLE `training_history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgkmgfi2j8pb54uisnr2gcx7s3` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `schedules`
--
ALTER TABLE `schedules`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tasks`
--
ALTER TABLE `tasks`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `todo_lists`
--
ALTER TABLE `todo_lists`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `training_history`
--
ALTER TABLE `training_history`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `schedules`
--
ALTER TABLE `schedules`
  ADD CONSTRAINT `FKd4y4xekwahv9boo6lc8gfl3jv` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `tasks`
--
ALTER TABLE `tasks`
  ADD CONSTRAINT `FK8csrtw05jkes3eoauc9b23q5g` FOREIGN KEY (`todo_list_id`) REFERENCES `todo_lists` (`id`);

--
-- Constraints for table `todo_lists`
--
ALTER TABLE `todo_lists`
  ADD CONSTRAINT `FKmcbclfxid1om8c1ofver4ye2b` FOREIGN KEY (`schedule_id`) REFERENCES `schedules` (`id`);

--
-- Constraints for table `training_history`
--
ALTER TABLE `training_history`
  ADD CONSTRAINT `FKgkmgfi2j8pb54uisnr2gcx7s3` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
