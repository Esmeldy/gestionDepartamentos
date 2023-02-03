-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-05-2022 a las 00:28:06
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de datos: `03174791d`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamentos`
--

CREATE TABLE  IF NOT EXISTS `departamentos` (
  `Codigo` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `IdLocalizacion` int(11) NOT NULL,
  `IdManager` int(11) NOT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `departamentos`
--

INSERT INTO `departamentos` (`Codigo`, `Nombre`, `IdLocalizacion`, `IdManager`) VALUES
(1, 'Daniel', 1, 10),
(2, 'Karla', 3, 20),
(3, 'Nina', 5, 11),
(4, 'Marta', 10, 20),
(5, 'Martín', 1, 10),
(6, 'Xavi', 5, 20),
(7, 'Fermín', 10, 2),
(8, 'Aida', 4, 1),
(9, 'Juan Pablo', 2, 30),
(10, 'Jose Manuel', 5, 11),
(11, 'Taison', 10, 30),
(12, 'Gabriela', 3, 20),
(13, 'Marcos', 2, 30);