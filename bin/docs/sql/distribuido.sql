/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.4.6-MariaDB : Database - distribuido
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`distribuido` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `distribuido`;

/*Table structure for table `articulo` */

DROP TABLE IF EXISTS `articulo`;

CREATE TABLE `articulo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `es_insumo` bit(1) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `precio_compra` float DEFAULT NULL,
  `precio_venta` float DEFAULT NULL,
  `stock_actual` int(11) DEFAULT NULL,
  `stock_max` int(11) DEFAULT NULL,
  `stock_min` int(11) DEFAULT NULL,
  `articulo_categoria_articulo` bigint(20) DEFAULT NULL,
  `articulo_medida_articulo` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqhpb77pywj7tycrx5m51n5bmh` (`articulo_categoria_articulo`),
  KEY `FKha1tua7j1xdss5i894ltgv45r` (`articulo_medida_articulo`),
  CONSTRAINT `FKha1tua7j1xdss5i894ltgv45r` FOREIGN KEY (`articulo_medida_articulo`) REFERENCES `medidaarticulo` (`id`),
  CONSTRAINT `FKqhpb77pywj7tycrx5m51n5bmh` FOREIGN KEY (`articulo_categoria_articulo`) REFERENCES `categoriaarticulo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `articulo` */

/*Table structure for table `categoriaarticulo` */

DROP TABLE IF EXISTS `categoriaarticulo`;

CREATE TABLE `categoriaarticulo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `categoria_articulo_categoria_articulo` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1tsm00x9eg5k4fo8eepyrosn1` (`categoria_articulo_categoria_articulo`),
  CONSTRAINT `FK1tsm00x9eg5k4fo8eepyrosn1` FOREIGN KEY (`categoria_articulo_categoria_articulo`) REFERENCES `categoriaarticulo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `categoriaarticulo` */

/*Table structure for table `categoriaplato` */

DROP TABLE IF EXISTS `categoriaplato`;

CREATE TABLE `categoriaplato` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `categoria_plato_categoria_plato` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtbpos759xwvkr2wc448c043pu` (`categoria_plato_categoria_plato`),
  CONSTRAINT `FKtbpos759xwvkr2wc448c043pu` FOREIGN KEY (`categoria_plato_categoria_plato`) REFERENCES `categoriaplato` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `categoriaplato` */

/*Table structure for table `departamento` */

DROP TABLE IF EXISTS `departamento`;

CREATE TABLE `departamento` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `departamento` */

/*Table structure for table `detalle_pedido` */

DROP TABLE IF EXISTS `detalle_pedido`;

CREATE TABLE `detalle_pedido` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `sub_total` double NOT NULL,
  `detalle_pedido_plato` bigint(20) DEFAULT NULL,
  `detalle_pedido_pedido` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqisoaa1mrcucegb9b7emn18wp` (`detalle_pedido_plato`),
  KEY `FKc8dkvjupq9y3ipnqpnw126943` (`detalle_pedido_pedido`),
  CONSTRAINT `FKc8dkvjupq9y3ipnqpnw126943` FOREIGN KEY (`detalle_pedido_pedido`) REFERENCES `pedido` (`id`),
  CONSTRAINT `FKqisoaa1mrcucegb9b7emn18wp` FOREIGN KEY (`detalle_pedido_plato`) REFERENCES `plato` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `detalle_pedido` */

insert  into `detalle_pedido`(`id`,`cantidad`,`sub_total`,`detalle_pedido_plato`,`detalle_pedido_pedido`) values (1,1,10,1,1),(2,2,20,2,1),(3,1,15,3,1);

/*Table structure for table `detalleplato` */

DROP TABLE IF EXISTS `detalleplato`;

CREATE TABLE `detalleplato` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) DEFAULT NULL,
  `detalle_plato_articulo` bigint(20) DEFAULT NULL,
  `detalle_plato_medida_plato` bigint(20) DEFAULT NULL,
  `detalle_plato_plato` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb6jwaqoqif8gqevegvjajbmyf` (`detalle_plato_articulo`),
  KEY `FKoygf7hiefutq2ahaougfcown4` (`detalle_plato_medida_plato`),
  KEY `FKea1rfbbm82lsbbqn0npev8oda` (`detalle_plato_plato`),
  CONSTRAINT `FKb6jwaqoqif8gqevegvjajbmyf` FOREIGN KEY (`detalle_plato_articulo`) REFERENCES `articulo` (`id`),
  CONSTRAINT `FKea1rfbbm82lsbbqn0npev8oda` FOREIGN KEY (`detalle_plato_plato`) REFERENCES `plato` (`id`),
  CONSTRAINT `FKoygf7hiefutq2ahaougfcown4` FOREIGN KEY (`detalle_plato_medida_plato`) REFERENCES `medidaplato` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `detalleplato` */

/*Table structure for table `domicilio` */

DROP TABLE IF EXISTS `domicilio`;

CREATE TABLE `domicilio` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `barrio` varchar(255) DEFAULT NULL,
  `calle` varchar(255) DEFAULT NULL,
  `manzana` char(1) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `piso` int(11) DEFAULT NULL,
  `puerta` varchar(255) DEFAULT NULL,
  `localidad_id` bigint(20) DEFAULT NULL,
  `domicilio_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8t63gx4v022qapv45vdwld71j` (`localidad_id`),
  KEY `FK4tamowq24qo5ndq38k0fck6pv` (`domicilio_usuario`),
  CONSTRAINT `FK4tamowq24qo5ndq38k0fck6pv` FOREIGN KEY (`domicilio_usuario`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FK8t63gx4v022qapv45vdwld71j` FOREIGN KEY (`localidad_id`) REFERENCES `localidad` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `domicilio` */

/*Table structure for table `empresa` */

DROP TABLE IF EXISTS `empresa`;

CREATE TABLE `empresa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `empresa_cajero` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhyapm0i83cps0x3ho4wkb0jwp` (`empresa_cajero`),
  CONSTRAINT `FKhyapm0i83cps0x3ho4wkb0jwp` FOREIGN KEY (`empresa_cajero`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `empresa` */

/*Table structure for table `estado` */

DROP TABLE IF EXISTS `estado`;

CREATE TABLE `estado` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `estado` */

/*Table structure for table `factura` */

DROP TABLE IF EXISTS `factura`;

CREATE TABLE `factura` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descuento` double NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `numero` int(11) NOT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `factura` */

insert  into `factura`(`id`,`descuento`,`fecha`,`numero`,`total`) values (1,20,'2020-06-30 13:07:30',222,60);

/*Table structure for table `forma_pago` */

DROP TABLE IF EXISTS `forma_pago`;

CREATE TABLE `forma_pago` (
  `dtype` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cantidad_pagado` double NOT NULL,
  `cantidad_cuotas` int(11) DEFAULT NULL,
  `cvv` int(11) DEFAULT NULL,
  `numero_de_tarjeta` bigint(20) DEFAULT NULL,
  `numero_documento` bigint(20) DEFAULT NULL,
  `pin` int(11) DEFAULT NULL,
  `tipo_de_tarjeta` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `forma_pago` */

insert  into `forma_pago`(`dtype`,`id`,`cantidad_pagado`,`cantidad_cuotas`,`cvv`,`numero_de_tarjeta`,`numero_documento`,`pin`,`tipo_de_tarjeta`) values ('TARJETA',1,100,3,111,111,111,111,'credito');

/*Table structure for table `localidad` */

DROP TABLE IF EXISTS `localidad`;

CREATE TABLE `localidad` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(255) DEFAULT NULL,
  `departamento_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK53bfl9yp28l81i0ufyrd0i0i7` (`departamento_id`),
  CONSTRAINT `FK53bfl9yp28l81i0ufyrd0i0i7` FOREIGN KEY (`departamento_id`) REFERENCES `departamento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `localidad` */

/*Table structure for table `medidaarticulo` */

DROP TABLE IF EXISTS `medidaarticulo`;

CREATE TABLE `medidaarticulo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `medidaarticulo` */

/*Table structure for table `medidaplato` */

DROP TABLE IF EXISTS `medidaplato`;

CREATE TABLE `medidaplato` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `medidaplato` */

/*Table structure for table `pedido` */

DROP TABLE IF EXISTS `pedido`;

CREATE TABLE `pedido` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `con_delivery` bit(1) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `hora_estimada_fin` datetime DEFAULT NULL,
  `numero` int(11) NOT NULL,
  `precio_final` float DEFAULT NULL,
  `total` float DEFAULT NULL,
  `cliente_id` bigint(20) DEFAULT NULL,
  `cocinero_id` bigint(20) DEFAULT NULL,
  `delivery_id` bigint(20) DEFAULT NULL,
  `pedido_domicilio_pedido` bigint(20) DEFAULT NULL,
  `estado_pedido` bigint(20) DEFAULT NULL,
  `factura_id` bigint(20) DEFAULT NULL,
  `forma_pago_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK37ms39e5dvx6m05hftvx9uavk` (`cliente_id`),
  KEY `FK7rm85j5jigddu4i9c2gnxjhdq` (`cocinero_id`),
  KEY `FK5oowf8rgh64043tecufmxe820` (`delivery_id`),
  KEY `FKlc1jl3qnsl0rmrk7jbrkkhsoc` (`pedido_domicilio_pedido`),
  KEY `FKi7xq69w5mgdb72ygcaj2uktnq` (`estado_pedido`),
  KEY `FKpa5hywhn7so5bn1ctm1yhwuei` (`factura_id`),
  KEY `FKhpfo4qt0gh5c7omipodcj8e9c` (`forma_pago_id`),
  CONSTRAINT `FK37ms39e5dvx6m05hftvx9uavk` FOREIGN KEY (`cliente_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FK5oowf8rgh64043tecufmxe820` FOREIGN KEY (`delivery_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FK7rm85j5jigddu4i9c2gnxjhdq` FOREIGN KEY (`cocinero_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKhpfo4qt0gh5c7omipodcj8e9c` FOREIGN KEY (`forma_pago_id`) REFERENCES `forma_pago` (`id`),
  CONSTRAINT `FKi7xq69w5mgdb72ygcaj2uktnq` FOREIGN KEY (`estado_pedido`) REFERENCES `estado` (`id`),
  CONSTRAINT `FKlc1jl3qnsl0rmrk7jbrkkhsoc` FOREIGN KEY (`pedido_domicilio_pedido`) REFERENCES `domicilio` (`id`),
  CONSTRAINT `FKpa5hywhn7so5bn1ctm1yhwuei` FOREIGN KEY (`factura_id`) REFERENCES `factura` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `pedido` */

insert  into `pedido`(`id`,`con_delivery`,`fecha`,`hora_estimada_fin`,`numero`,`precio_final`,`total`,`cliente_id`,`cocinero_id`,`delivery_id`,`pedido_domicilio_pedido`,`estado_pedido`,`factura_id`,`forma_pago_id`) values (1,'','2020-06-01 13:08:12','2020-07-01 13:08:16',4444,60,200,NULL,NULL,NULL,NULL,NULL,1,1),(2,'','2020-07-04 16:47:21','2020-07-01 16:48:25',1111,11,11,NULL,NULL,NULL,NULL,NULL,1,1),(3,'','2020-07-07 16:47:49','2020-07-01 16:48:28',111,11,11,NULL,NULL,NULL,NULL,NULL,1,1),(4,'','2020-07-09 16:48:03','2020-07-01 16:48:30',1111,11,11,NULL,NULL,NULL,NULL,NULL,1,1);

/*Table structure for table `plato` */

DROP TABLE IF EXISTS `plato`;

CREATE TABLE `plato` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `precio_venta` float DEFAULT NULL,
  `receta` longtext DEFAULT NULL,
  `tiempo_preparacion` int(11) DEFAULT NULL,
  `plato_categoria_plato` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb3iq3qffjbfq05jk8p85k58ol` (`plato_categoria_plato`),
  CONSTRAINT `FKb3iq3qffjbfq05jk8p85k58ol` FOREIGN KEY (`plato_categoria_plato`) REFERENCES `categoriaplato` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `plato` */

insert  into `plato`(`id`,`denominacion`,`imagen`,`precio_venta`,`receta`,`tiempo_preparacion`,`plato_categoria_plato`) values (1,'Pizza','asdf',10,'asdfasdf',15,NULL),(2,'Empanada','asdf',10,'sdasdfasdf',15,NULL),(3,'Lomo','asdf',15,'sdfasdfasdf',15,NULL);

/*Table structure for table `rol` */

DROP TABLE IF EXISTS `rol`;

CREATE TABLE `rol` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rol` */

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `tipo` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` bigint(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `esta_activo` bit(1) DEFAULT NULL,
  `fecha_ingreso_empleado` datetime DEFAULT NULL,
  `cargo` varchar(255) DEFAULT NULL,
  `usuario_rol` bigint(20) DEFAULT NULL,
  `empresa_cocinero` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjh57ef3il4piq9e9b4idkkh12` (`usuario_rol`),
  KEY `FKe61luqplvoonh3s37amg5xlg5` (`empresa_cocinero`),
  CONSTRAINT `FKe61luqplvoonh3s37amg5xlg5` FOREIGN KEY (`empresa_cocinero`) REFERENCES `empresa` (`id`),
  CONSTRAINT `FKjh57ef3il4piq9e9b4idkkh12` FOREIGN KEY (`usuario_rol`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
