-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 14-11-2019 a las 17:42:56
-- Versión del servidor: 5.7.17-log
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `controlnotas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `ida` int(11) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `foto` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`ida`, `nombre`, `apellidos`, `foto`) VALUES
(1, 'Angela', 'Olivares Valerio', '1.jpg'),
(2, 'Anann', 'Valle Villa', '2.jpg'),
(3, 'Angel', 'Vilca Laos', '3.jpg'),
(4, 'Antonio', 'Tarrillo Huanca', '4.jpg'),
(5, 'Natalia', 'Baltazar Vilchez', '5.jpg'),
(6, 'fabrizio', 'CONDORI', '5KPH');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `idc` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`idc`, `nombre`) VALUES
(1, 'Java Web Básico'),
(2, 'Angular'),
(3, 'Matemática'),
(4, 'Base de Datos'),
(5, 'lenguaje');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evaluación`
--

CREATE TABLE `evaluación` (
  `ida` int(11) NOT NULL,
  `idc` int(11) NOT NULL,
  `nota1` double NOT NULL,
  `nota2` double NOT NULL,
  `promedio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `evaluación`
--

INSERT INTO `evaluación` (`ida`, `idc`, `nota1`, `nota2`, `promedio`) VALUES
(2, 2, 12, 13, 12.5),
(4, 2, 12, 13, 12.5),
(1, 1, 13, 14, 13.5),
(3, 3, 0, 0, 0),
(5, 4, 12, 17, 14.5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`ida`);

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`idc`);

--
-- Indices de la tabla `evaluación`
--
ALTER TABLE `evaluación`
  ADD KEY `idc` (`idc`),
  ADD KEY `ida` (`ida`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `ida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `curso`
--
ALTER TABLE `curso`
  MODIFY `idc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
