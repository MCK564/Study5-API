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
-- Database: `study5_payment`
--

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `bank` varchar(255) DEFAULT NULL,
  `course_id` bigint DEFAULT NULL,
  `description` longtext,
  `payment_status` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `price` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `bank`, `course_id`, `description`, `payment_status`, `user_id`, `email`, `price`) VALUES
(5, NULL, '2025-11-24 14:06:41.105996', NULL, '2025-11-24 14:06:41.106034', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(6, NULL, '2025-11-24 14:13:33.145918', NULL, '2025-11-24 14:13:33.145955', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(7, NULL, '2025-11-24 14:17:25.050825', NULL, '2025-11-24 14:17:25.050862', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(8, NULL, '2025-11-24 14:23:59.667949', NULL, '2025-11-24 14:23:59.668033', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(9, NULL, '2025-11-24 14:48:08.407814', NULL, '2025-11-24 14:48:08.407857', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(10, NULL, '2025-11-24 14:53:28.780035', NULL, '2025-11-24 14:53:28.780054', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(11, NULL, '2025-11-24 15:00:00.231706', NULL, '2025-11-24 15:00:00.231726', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(12, NULL, '2025-11-24 15:04:14.640496', NULL, '2025-11-24 15:04:14.640545', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(13, NULL, '2025-11-24 15:16:35.631509', NULL, '2025-11-24 15:16:35.631572', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(14, NULL, '2025-11-24 15:23:38.105577', NULL, '2025-11-24 15:23:38.105637', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(15, NULL, '2025-11-24 15:36:56.490648', NULL, '2025-11-24 15:36:56.490694', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(16, NULL, '2025-11-24 16:34:15.232406', NULL, '2025-11-24 16:34:15.232440', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(17, NULL, '2025-11-24 16:50:22.174461', NULL, '2025-11-24 16:50:22.174505', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(18, NULL, '2025-11-24 17:11:11.596842', NULL, '2025-11-24 17:11:11.596874', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(19, NULL, '2025-11-24 17:25:09.536045', NULL, '2025-11-24 17:25:09.536200', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(20, NULL, '2025-11-24 17:34:21.145062', NULL, '2025-11-24 17:34:21.145120', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(21, NULL, '2025-11-24 17:42:17.365458', NULL, '2025-11-24 17:42:17.365494', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(22, NULL, '2025-11-24 17:56:12.870303', NULL, '2025-11-24 17:56:12.870345', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(23, NULL, '2025-11-24 18:03:00.309936', NULL, '2025-11-24 18:03:00.309983', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(24, NULL, '2025-11-24 18:09:24.941234', NULL, '2025-11-24 18:09:24.941270', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(25, NULL, '2025-11-25 04:36:02.655153', NULL, '2025-11-25 04:36:02.655199', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(26, NULL, '2025-11-25 04:46:25.636399', NULL, '2025-11-25 04:46:25.636445', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(27, NULL, '2025-11-25 05:29:39.998568', NULL, '2025-11-25 05:29:39.998748', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(28, NULL, '2025-11-25 07:15:11.881418', NULL, '2025-11-25 07:15:11.881451', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(29, NULL, '2025-11-25 07:30:17.666196', NULL, '2025-11-25 07:30:17.666235', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(30, NULL, '2025-11-25 16:57:03.694290', NULL, '2025-11-25 16:57:03.694328', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(31, NULL, '2025-11-25 17:18:31.845959', NULL, '2025-11-25 17:18:31.846003', NULL, 4, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 989000),
(32, NULL, '2025-11-26 01:10:06.355804', NULL, '2025-11-26 01:10:06.355832', NULL, 21, 'Thanh toan khoa hoc', NULL, 8, 'chikha13122@gmail.com', 35000),
(33, NULL, '2025-11-26 01:40:50.739003', NULL, '2025-11-26 01:46:05.363088', NULL, 21, 'Thanh toan khoa hoc', 'SUCCESS', 8, 'chikha13122@gmail.com', 35000),
(34, NULL, '2025-11-26 01:52:54.772494', NULL, '2025-11-26 01:53:28.242565', NULL, 21, 'Thanh toan khoa hoc', 'SUCCESS', 8, 'chikha13122@gmail.com', 35000),
(35, NULL, '2025-11-26 07:35:26.764550', NULL, '2025-11-26 07:36:12.721635', NULL, 22, 'Thanh toan khoa hoc', 'SUCCESS', 8, 'chikha13122@gmail.com', 25000),
(36, NULL, '2025-11-26 08:13:00.685474', NULL, '2025-11-26 08:13:00.685530', NULL, 22, 'Thanh toan khoa hoc AWS Flash - SaaS Technical Fundamentals Advance2 - Chí Kha', 'PENDING', 6, 'chikha13122@gmail.com', 25000),
(37, NULL, '2025-11-26 08:13:47.183101', NULL, '2025-11-26 08:13:47.183128', NULL, 22, 'Thanh toan khoa hoc AWS Flash - SaaS Technical Fundamentals Advance2 - Chí Kha', 'PENDING', 6, 'chikha13122@gmail.com', 25000),
(38, NULL, '2025-11-26 08:14:05.303957', NULL, '2025-11-26 08:14:05.303988', NULL, 22, 'Thanh toan khoa hoc AWS Flash - SaaS Technical Fundamentals Advance2 - Chí Kha', 'PENDING', 6, 'chikha13122@gmail.com', 25000),
(39, NULL, '2025-11-26 08:14:17.033135', NULL, '2025-11-26 08:14:17.033166', NULL, 22, 'Thanh toan khoa hoc AWS Flash - SaaS Technical Fundamentals Advance2 - Chí Kha', 'PENDING', 6, 'chikha13122@gmail.com', 25000),
(40, NULL, '2025-12-01 05:13:16.143728', NULL, '2025-12-01 05:13:16.143774', NULL, 22, 'Thanh toan khoa hoc AWS Flash - SaaS Technical Fundamentals Advance2 - Chí Kha', 'PENDING', 6, 'chikha13122@gmail.com', 25000),
(41, NULL, '2025-12-01 05:14:08.520853', NULL, '2025-12-01 05:14:08.520869', NULL, 22, 'Thanh toan khoa hoc AWS Flash - SaaS Technical Fundamentals Advance2 - Chí Kha', 'PENDING', 6, 'chikha13122@gmail.com', 25000),
(42, NULL, '2025-12-01 05:14:11.094803', NULL, '2025-12-01 05:14:11.094827', NULL, 22, 'Thanh toan khoa hoc AWS Flash - SaaS Technical Fundamentals Advance2 - Chí Kha', 'PENDING', 6, 'chikha13122@gmail.com', 25000),
(43, NULL, '2025-12-01 05:24:18.174801', NULL, '2025-12-01 05:26:02.898487', NULL, 22, 'Thanh toán khóa học', 'SUCCESS', 6, 'chikha13122@gmail.com', 25000),
(44, NULL, '2025-12-01 05:36:12.187968', NULL, '2025-12-01 05:36:39.905707', NULL, 22, 'Thanh toán khóa học', 'SUCCESS', 6, 'chikha13122@gmail.com', 25000),
(45, NULL, '2025-12-01 05:41:51.950881', NULL, '2025-12-01 05:42:15.784951', NULL, 22, 'Thanh toán khóa học', 'SUCCESS', 6, 'chikha13122@gmail.com', 25000),
(46, NULL, '2025-12-01 05:49:46.228666', NULL, '2025-12-01 05:50:26.676176', NULL, 22, 'Thanh toán khóa học', 'SUCCESS', 6, 'chikha13122@gmail.com', 25000),
(47, NULL, '2025-12-01 05:52:12.557474', NULL, '2025-12-01 05:52:34.906145', NULL, 22, 'Thanh toan khoa hoc', 'SUCCESS', 6, 'chikha13122@gmail.com', 25000),
(48, NULL, '2025-12-02 17:33:01.515760', NULL, '2025-12-02 17:33:22.386280', NULL, 22, 'Thanh toan khoa hoc', 'SUCCESS', 10, '52200050@student.tdtu.edu.vn', 22000),
(49, NULL, '2025-12-03 06:24:25.069742', NULL, '2025-12-03 06:25:06.054510', NULL, 23, 'Thanh toan khoa hoc aws3', 'SUCCESS', 10, '52200050@student.tdtu.edu.vn', 20000),
(50, NULL, '2025-12-10 06:14:51.135547', NULL, '2025-12-10 06:15:34.942427', NULL, 24, 'asdfasdfasdfasf', 'SUCCESS', 10, '52200050@student.tdtu.edu.vn', 15000),
(51, NULL, '2025-12-10 06:56:11.450218', NULL, '2025-12-10 06:56:47.117978', NULL, 25, 'thanh toán', 'SUCCESS', 6, 'chikha13122@gmail.com', 10000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
