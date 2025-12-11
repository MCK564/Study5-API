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
-- Database: `study5_auth`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `display_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `login_type` varchar(255) DEFAULT NULL,
  `sub` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `display_name`, `email`, `password`, `username`, `created_by`, `created_date`, `modified_by`, `modified_date`, `role`, `login_type`, `sub`) VALUES
(6, 'Chí Kha', 'chikha13122@gmail.com', NULL, NULL, NULL, '2025-11-15 08:14:11.427364', NULL, '2025-11-15 08:14:11.427396', 'USER', 'GOOGLE', NULL),
(7, 'Chí Kha', 'khamai05767@gmail.com', NULL, NULL, NULL, '2025-11-21 17:43:54.427856', NULL, '2025-11-21 17:43:54.428060', 'USER', 'GOOGLE', NULL),
(8, 'Admin', 'admin@example.com', '$2y$06$dfXKsXxjUqFYHhG0WXE0FeiKPYa1irCPp78u6hNRVG1i7HAuJx4XW', 'admin', NULL, '2025-11-23 09:33:45.000000', NULL, '2025-11-23 09:33:45.000000', 'ADMIN', 'LOCAL', NULL),
(9, 'Lê Nguyễn Hoàng Yến', '522h0113@student.tdtu.edu.vn', NULL, NULL, NULL, '2025-12-02 17:01:27.520690', NULL, '2025-12-02 17:01:27.520728', 'USER', 'GOOGLE', NULL),
(10, 'Mai Chí Kha', '52200050@student.tdtu.edu.vn', NULL, NULL, NULL, '2025-12-02 17:07:33.827603', NULL, '2025-12-02 17:07:33.827619', 'USER', 'GOOGLE', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
