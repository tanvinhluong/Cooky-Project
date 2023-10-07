-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 07, 2023 lúc 10:10 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `cookymanagement`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `ID_ACCOUNT` int(10) NOT NULL,
  `USERNAME` varchar(16) NOT NULL,
  `PASSWORD` varchar(16) NOT NULL,
  `ROLE_ID` int(10) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `admin`
--

CREATE TABLE `admin` (
  `ID_ADMIN` int(10) NOT NULL,
  `ID_ACCOUNT` int(10) NOT NULL,
  `HO` varchar(50) NOT NULL,
  `TEN` varchar(30) NOT NULL,
  `PHAI` varchar(5) NOT NULL,
  `DIACHI` varchar(100) NOT NULL,
  `SODT` varchar(20) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `NGAYCAP` datetime NOT NULL DEFAULT current_timestamp()
) ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `ID_CATEGORY` int(10) NOT NULL,
  `NAME` varchar(50) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categorydetails`
--

CREATE TABLE `categorydetails` (
  `ID` int(10) NOT NULL,
  `ID_CATEGORY` int(10) NOT NULL,
  `ID_FOOD` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `favorite`
--

CREATE TABLE `favorite` (
  `ID` int(10) NOT NULL,
  `ID_USER` int(10) NOT NULL,
  `FAVORITED` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `fooddetails`
--

CREATE TABLE `fooddetails` (
  `ID` int(10) NOT NULL,
  `ID_FOOD` int(10) NOT NULL,
  `ID_INGREDIENT` int(10) NOT NULL,
  `QUANTITY` int(10) NOT NULL,
  `UNITPRICE` int(10) NOT NULL,
  `UNITCALORIES` int(10) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `foods`
--

CREATE TABLE `foods` (
  `ID_FOOD` int(10) NOT NULL,
  `FOODNAME` varchar(100) NOT NULL,
  `PREPARETIME` varchar(20) DEFAULT NULL,
  `COOKINGTIME` varchar(500) DEFAULT NULL,
  `DIFFICULTY` varchar(15) DEFAULT NULL,
  `TIPS` varchar(5000) DEFAULT NULL,
  `RECIPE` varchar(5000) DEFAULT NULL,
  `DETAILS` varchar(100) DEFAULT NULL
) ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ingredients`
--

CREATE TABLE `ingredients` (
  `ID_INGREDIENT` int(10) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `PRICE` int(10) NOT NULL,
  `CALORIES` int(10) NOT NULL,
  `UNIT` varchar(10) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
  `ROLE_ID` int(10) NOT NULL,
  `ROLENAME` varchar(100) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `ID_USER` int(10) NOT NULL,
  `ID_ACCOUNT` int(10) NOT NULL,
  `HO` varchar(50) NOT NULL,
  `TEN` varchar(30) NOT NULL,
  `PHAI` varchar(5) NOT NULL,
  `DIACHI` varchar(100) DEFAULT NULL,
  `SODT` varchar(20) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `NGAYTAO` datetime NOT NULL DEFAULT current_timestamp()
) ;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`ID_ACCOUNT`),
  ADD UNIQUE KEY `USERNAME` (`USERNAME`),
  ADD KEY `USERNAME_2` (`USERNAME`),
  ADD KEY `ROLE_ID` (`ROLE_ID`);

--
-- Chỉ mục cho bảng `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`ID_ADMIN`),
  ADD UNIQUE KEY `EMAIL` (`EMAIL`),
  ADD UNIQUE KEY `ID_ACCOUNT` (`ID_ACCOUNT`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`ID_CATEGORY`);

--
-- Chỉ mục cho bảng `categorydetails`
--
ALTER TABLE `categorydetails`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_CATEGORY` (`ID_CATEGORY`),
  ADD KEY `ID_FOOD` (`ID_FOOD`);

--
-- Chỉ mục cho bảng `favorite`
--
ALTER TABLE `favorite`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_USER` (`ID_USER`);

--
-- Chỉ mục cho bảng `fooddetails`
--
ALTER TABLE `fooddetails`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_FOOD` (`ID_FOOD`),
  ADD KEY `ID_INGREDIENT` (`ID_INGREDIENT`);

--
-- Chỉ mục cho bảng `foods`
--
ALTER TABLE `foods`
  ADD PRIMARY KEY (`ID_FOOD`);

--
-- Chỉ mục cho bảng `ingredients`
--
ALTER TABLE `ingredients`
  ADD PRIMARY KEY (`ID_INGREDIENT`);

--
-- Chỉ mục cho bảng `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`ROLE_ID`),
  ADD UNIQUE KEY `ROLENAME_2` (`ROLENAME`),
  ADD KEY `ROLENAME` (`ROLENAME`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID_USER`),
  ADD UNIQUE KEY `EMAIL` (`EMAIL`),
  ADD UNIQUE KEY `ID_ACCOUNT` (`ID_ACCOUNT`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `account`
--
ALTER TABLE `account`
  MODIFY `ID_ACCOUNT` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `admin`
--
ALTER TABLE `admin`
  MODIFY `ID_ADMIN` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `ID_CATEGORY` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `categorydetails`
--
ALTER TABLE `categorydetails`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `favorite`
--
ALTER TABLE `favorite`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `fooddetails`
--
ALTER TABLE `fooddetails`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `foods`
--
ALTER TABLE `foods`
  MODIFY `ID_FOOD` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ingredients`
--
ALTER TABLE `ingredients`
  MODIFY `ID_INGREDIENT` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `role`
--
ALTER TABLE `role`
  MODIFY `ROLE_ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `ID_USER` int(10) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`);

--
-- Các ràng buộc cho bảng `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`ID_ACCOUNT`) REFERENCES `account` (`ID_ACCOUNT`);

--
-- Các ràng buộc cho bảng `categorydetails`
--
ALTER TABLE `categorydetails`
  ADD CONSTRAINT `categorydetails_ibfk_1` FOREIGN KEY (`ID_CATEGORY`) REFERENCES `category` (`ID_CATEGORY`),
  ADD CONSTRAINT `categorydetails_ibfk_2` FOREIGN KEY (`ID_FOOD`) REFERENCES `foods` (`ID_FOOD`);

--
-- Các ràng buộc cho bảng `favorite`
--
ALTER TABLE `favorite`
  ADD CONSTRAINT `favorite_ibfk_1` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID_USER`);

--
-- Các ràng buộc cho bảng `fooddetails`
--
ALTER TABLE `fooddetails`
  ADD CONSTRAINT `fooddetails_ibfk_1` FOREIGN KEY (`ID_INGREDIENT`) REFERENCES `ingredients` (`ID_INGREDIENT`),
  ADD CONSTRAINT `fooddetails_ibfk_2` FOREIGN KEY (`ID_FOOD`) REFERENCES `foods` (`ID_FOOD`);

--
-- Các ràng buộc cho bảng `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`ID_ACCOUNT`) REFERENCES `account` (`ID_ACCOUNT`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
