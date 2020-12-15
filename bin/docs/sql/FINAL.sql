/*
SQLyog Ultimate v9.63 
MySQL - 5.5.5-10.4.13-MariaDB : Database - distribuido
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`distribuido` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `distribuido`;

/*Data for the table `articulo` */

insert  into `articulo`(`id`,`status`,`denominacion`,`descripcion`,`es_insumo`,`imagen`,`precio_compra`,`precio_venta`,`stock_actual`,`stock_max`,`stock_min`,`articulo_categoria_articulo`,`articulo_medida_articulo`) values (1,'','Bife ','Carne roja','','https://ahumadoras.com/images/bife-chorizo-550x366.jpg',200,350,30,100,50,1,1),(2,'','Medallon de carne','Circular','','https://http2.mlstatic.com/medallones-de-carne-vacuno-D_NQ_NP_872776-MLA42068330478_062020-F.jpg',40,70,70,100,40,2,5),(3,'','Lechuga','Verde','','https://www.jardineriaon.com/wp-content/uploads/2019/10/Lechuga-batavia.jpg',20,30,700,1300,200,3,2),(4,'','Tomate','Rojo','','https://frutasyverduras.info/wp-content/uploads/2019/07/tomate-1024x680.jpg',60,80,10,12,4,3,1),(5,'','Agua saborizada','Sabor pomelo','\0','https://statics.dinoonline.com.ar/imagenes/full_600x600_ma/3040317_f.jpg',75,150,30,40,12,5,5),(6,'','Pan para hamburguesas','Pan redondo','','https://i.ytimg.com/vi/DDgnJZyRB6I/maxresdefault.jpg',30,50,120,120,80,8,5),(7,'','Pan arabe','Pan rico','','https://i.pinimg.com/originals/c9/db/13/c9db1304727671ec6d64495daa674ca9.jpg',40,80,80,90,40,8,5),(8,'','Chorizo','Porcino','','https://d26lpennugtm8s.cloudfront.net/stores/562/484/products/35-chorizo-especial11-20536b77423e160f0115119522834356-640-0.jpg',80,150,40,40,10,7,5),(9,'','Pan francés','Rico pan','','https://okdiario.com/img/recetas/2017/08/18/baguettes-o-pan-frances-2.jpg',70,140,30,80,10,8,5),(10,'','Red IPA','Cerveza roja','\0','https://jumboargentina.vteximg.com.br/arquivos/ids/551145-750-750/Cerveza-Rabieta-Red-Ipa-473cc-1-819459.jpg?v=637063609845630000',120,260,40,60,20,6,5),(11,'','Quilmes 970ml','Bebida rica','\0','https://vinotecalavia.com/3543-large_default/quilmes-cristal-retornable-x-970.jpg',140,240,20,80,60,6,5);

/*Data for the table `categoriaarticulo` */

insert  into `categoriaarticulo`(`id`,`status`,`denominacion`,`descripcion`,`categoria_articulo_categoria_articulo`) values (1,'','Carnes','Miscelaneo',NULL),(2,'','Carne de vaca','bovina',1),(3,'','Vegetales','verde',NULL),(4,'\0','Lechuga','verdecita',3),(5,'','Bebidas','para la sed',NULL),(6,'','Cervezas','bebida a base de cebada',5),(7,'','Carne de cerdo','Oink!',1),(8,'','Panes','Para sandwiches',NULL);

/*Data for the table `categoriaplato` */

insert  into `categoriaplato`(`id`,`status`,`denominacion`,`descripcion`,`categoria_plato_categoria_plato`) values (1,'','Sandwiches','Pan | comida | Pan',NULL),(2,'','Bebidas','Bebibles',NULL),(3,'','Bebidas alcoholicas','%alcoholico',2);

/*Data for the table `departamento` */

insert  into `departamento`(`id`,`status`,`denominacion`) values (1,'','Lavalle'),(2,'','Rivadavia'),(3,'','Tupungato'),(4,'','Las Heras'),(5,'','Tunuyán'),(6,'','San Carlos'),(7,'','Santa Rosa'),(8,'','Luján de Cuyo'),(9,'','General Alvear'),(10,'','Guaymallén'),(11,'','Malargüe'),(12,'','Godoy Cruz'),(13,'','Maipú'),(14,'','Capital'),(15,'','Junín'),(16,'','San Martín'),(17,'','San Rafael'),(18,'','La Paz');

/*Data for the table `detalle_pedido` */

/*Data for the table `detalleplato` */

insert  into `detalleplato`(`id`,`status`,`cantidad`,`detalle_plato_articulo`,`detalle_plato_plato`) values (1,NULL,1,5,1),(2,NULL,1,10,2),(3,NULL,4,9,3),(4,NULL,4,8,3),(5,NULL,20,3,3),(6,NULL,0.3,4,3),(7,NULL,2,2,4),(8,NULL,1,6,4),(9,NULL,0.2,4,4),(10,NULL,10,3,4),(11,NULL,0.5,1,5),(12,NULL,1,7,5),(13,NULL,0.35,3,5),(14,NULL,0.33,4,5);

/*Data for the table `domicilio` */

/*Data for the table `estado` */

insert  into `estado`(`id`,`status`,`denominacion`) values (1,'','RECHAZADO'),(2,'','ESPERA_APROBACION'),(3,'','ESPERANDO_CLIENTE'),(4,'','CARRITO'),(5,'','ESPERANDO_ASIGNACION'),(6,'','COCINA'),(7,'','COBRADO'),(8,'','ENTREGADO'),(9,'','EN_CAMINO'),(10,'','PREPARANDO'),(11,'','ESPERANDO_REPARTIDOR'),(12,'','NO_RETIRADO');

/*Data for the table `factura` */

/*Data for the table `forma_pago` */

/*Data for the table `localidad` */

insert  into `localidad`(`id`,`status`,`denominacion`,`departamento_id`) values (1,'','EL VERGEL',1),(2,'','BARRIO LA ESPERANZA',1),(3,'','BARRIO ALTO DEL OLVIDO',1),(4,'','BARRIO LA PEGA',1),(5,'','BARRIO LOS JARILLEROS',1),(6,'','BARRIO LAGUNAS DE BARTOLUZZI',1),(7,'','COSTA DE ARAUJO',1),(8,'','EL PARAMILLO',1),(9,'','BARRIO VIRGEN DEL ROSARIO',1),(10,'','INGENIERO GUSTAVO ANDRE',1),(11,'','LA COLONIA',15),(12,'','INGENIERO GIAGNONI',15),(13,'','JUNIN',15),(14,'','JOCOLI VIEJO',1),(15,'','LAS VIOLETAS',1),(16,'','3 DE MAYO',1),(17,'','BARRIO LOS OLIVOS',1),(18,'','BOWEN',9),(19,'','BARRIO LA PALMERA',1),(20,'','VILLA TULUMAYA',1),(21,'','CARMENSA',9),(22,'','GENERAL ALVEAR',9),(23,'','BARRIO MARIA AUXILIADORA',7),(24,'','LOS COMPARTOS',9),(25,'','BARRIO 12 DE OCTUBRE',7),(26,'','BARRIO MOLINA CABRERA',7),(27,'','LOS PENITENTES',8),(28,'','AGRELO',8),(29,'','BARRIO ADINA I Y II',8),(30,'','LOS BARRIALES',15),(31,'','MEDRANO',15),(32,'','PHILLIPS',15),(33,'','ANDRADE',2),(34,'','BARRIO RIVADAVIA',2),(35,'','BARRIO COOPERATIVA LOS CAMPAMENTOS',2),(36,'','RODRIGUEZ PEÑA',15),(37,'','MEDRANO',15),(38,'','ALTO VERDE',15),(39,'','LAS CATITAS',7),(40,'','LA DORMIDA',7),(41,'','BARRIO LA ESTACION',15),(42,'','SANTA ROSA',7),(43,'','BARRIO BELGRANO NORTE',3),(44,'','CORDON DEL PLATA',3),(45,'','EL PERAL',3),(46,'','AGUA ESCONDIDA',11),(47,'','LAS LEÑAS',11),(48,'','MALARGUE',11),(49,'','SAN JOSE',3),(50,'','TUPUNGATO',3),(51,'','LA ARBOLEDA',3),(52,'','EL ZAMPAL',3),(53,'','VILLA BASTIAS',3),(54,'','BARRIO PERDRIEL IV',8),(55,'','CACHEUTA',8),(56,'','1A. SECCION',14),(57,'','3A. SECCION',14),(58,'','2A. SECCION',14),(59,'','COSTA FLORES',8),(60,'','LOS MANANTIALES',8),(61,'','EL SALTO',8),(62,'','EL CARRIZAL',8),(63,'','LAS CARDITAS',8),(64,'','EL CARMELO',8),(65,'','BARRANCAS',13),(66,'','BARRIO JESUS DE NAZARET',13),(67,'','CRUZ DE PIEDRA',13),(68,'','BLANCO ENCALADA',4),(69,'','VILLA EL REFUGIO',8),(70,'','PIEDRAS BLANCAS',8),(71,'','LAS COMPUERTAS',8),(72,'','LAS VEGAS',8),(73,'','VALLE DEL SOL',8),(74,'','BARRIO EL NEVADO',17),(75,'','BARRIO CAMPOS EL TOLEDANO',17),(76,'','BARRIO EMPLEADOS DE COMERCIO',17),(77,'','CARRODILLA',8),(78,'','CHACRAS DE CORIA',8),(79,'','LUJAN DE CUYO',8),(80,'','PERDRIEL',8),(81,'','VISTALBA',8),(82,'','MAYOR DRUMMOND',8),(83,'','POTRERILLOS',8),(84,'','LA CENTRAL',2),(85,'','UGARTECHE',8),(86,'','LA ESPERANZA',2),(87,'','EL MIRADOR',2),(88,'','CUADRO ORTEGA',2),(89,'','LA FLORIDA',2),(90,'','LA LIBERTAD',2),(91,'','LOS ARBOLES',2),(92,'','LOS CAMPAMENTOS',2),(93,'','MUNDO NUEVO',2),(94,'','REDUCCION DE ABAJO',2),(95,'','SANTA MARIA DE ORO',2),(96,'','RIVADAVIA',2),(97,'','BARRIO SAN CAYETANO',5),(98,'','CAMPO LOS ANDES',5),(99,'','COLONIA LAS ROSAS',5),(100,'','EL MANZANO',5),(101,'','VISTA FLORES',5),(102,'','TUNUYAN',5),(103,'','LOS SAUCES',5),(104,'','COLONIA SEGOVIA',10),(105,'','BERMEJO',10),(106,'','BUENA NUEVA',10),(107,'','CAPILLA DEL ROSARIO',10),(108,'','EL SAUCE',10),(109,'','GENERAL BELGRANO',10),(110,'','JESUS NAZARENO',10),(111,'','LAS CAÑAS',10),(112,'','GUAYMALLEN',10),(113,'','RODEO DE LA CRUZ',10),(114,'','SAN FRANCISCO DEL MONTE',10),(115,'','VILLA NUEVA',10),(116,'','LA PRIMAVERA',10),(117,'','PUENTE DE HIERRO',10),(118,'','EL PEDREGAL',10),(119,'','LOS CORRALITOS',10),(120,'','GODOY CRUZ',12),(121,'','GOBERNADOR BENEGAS',12),(122,'','SAN FRANCISCO DEL MONTE',12),(123,'','PRESIDENTE SARMIENTO',12),(124,'','LAS TORTUGAS',12),(125,'','VILLA HIPODROMO',12),(126,'','VILLA MARINI',12),(127,'','DORREGO',12),(128,'','BARRIO EL CEPILLO',6),(129,'','BARRIO CARRASCO',6),(130,'','CHILECITO',6),(131,'','EUGENIO BUSTOS',6),(132,'','LA CONSULTA',6),(133,'','PAREDITAS',6),(134,'','SAN CARLOS',6),(135,'','4A. SECCION',14),(136,'','5A. SECCION',14),(137,'','6A. SECCION',14),(138,'','7A. SECCION',14),(139,'','9A. SECCION',14),(140,'','8A. SECCION',14),(141,'','10A. SECCION',14),(142,'','11A. SECCION',14),(143,'','PEDRO MOLINA',14),(144,'','SAN JOSE',14),(145,'','COQUIMBITO',13),(146,'','FRAY LUIS BELTRAN',13),(147,'','GENERAL GUTIERREZ',13),(148,'','RUSSELL',13),(149,'','RODEO DEL MEDIO',13),(150,'','MAIPU',13),(151,'','SAN ROQUE',13),(152,'','LUZURIAGA',13),(153,'','VILLA TERESA',13),(154,'','BARRIO CHIVILCOY',16),(155,'','DESAGUADERO',18),(156,'','VILLA ANTIGUA',18),(157,'','LA PAZ',18),(158,'','BARRIO EMANUEL',16),(159,'','BARRIO NTRA. SRA. DE FATIMA',16),(160,'','BARRIO LOS CHARABONES',16),(161,'','CHAPANAY',16),(162,'','EL RAMBLON',16),(163,'','EL ESPINO',16),(164,'','CHIVILCOY',16),(165,'','NUEVA CALIFORNIA',16),(166,'','PALMIRA',16),(167,'','MONTECASEROS',16),(168,'','TRES PORTEÑAS',16),(169,'','CIUDAD DE SAN MARTIN',16),(170,'','JOCOLI',4),(171,'','CAPDEVILA',4),(172,'','LAS CUEVAS',4),(173,'','LAS HERAS',4),(174,'','EL CHALLAO',4),(175,'','EL ALGARROBAL',4),(176,'','EL BORBOLLON',4),(177,'','EL RESGUARDO',4),(178,'','EL PLUMERILLO',4),(179,'','EL ZAPALLAR',4),(180,'','LA CIENEGUITA',4),(181,'','SIERRAS DE ENCALADA',4),(182,'','PANQUEHUA',4),(183,'','POLVAREDAS',4),(184,'','PUNTA DE VACAS',4),(185,'','PUENTE DEL INCA',4),(186,'','JOCOLI',4),(187,'','BARRIO JOCOLI II',4),(188,'','USPALLATA',4),(189,'','LA PUNTILLA',4),(190,'','CAPITAN MONTOYA',17),(191,'','BARRIO ECHEVERRIA',17),(192,'','BARRIO INTENDENCIA',17),(193,'','BARRIO LAS ROSAS',17),(194,'','BARRIO PRIMAVERA',17),(195,'','EL SOSNEADO',17),(196,'','EL NIHUIL',17),(197,'','EL TROPEZON',17),(198,'','GOUDGE',17),(199,'','JAIME PRATS',17),(200,'','LA LLAVE NUEVA',17),(201,'','LAS MALVINAS',17),(202,'','LOS REYUNOS',17),(203,'','MONTE COMAN',17),(204,'','POBRE DIABLO',17),(205,'','PUNTA DEL AGUA',17),(206,'','REAL DEL PADRE',17),(207,'','RAMA CAIDA',17),(208,'','CUADRO NACIONAL',17),(209,'','SALTO DE LAS ROSAS',17),(210,'','SAN RAFAEL',17),(211,'','25 DE MAYO',17),(212,'','VILLA ATUEL',17),(213,'','VILLA ATUEL NORTE',17);

/*Data for the table `medidaarticulo` */

insert  into `medidaarticulo`(`id`,`status`,`denominacion`) values (1,'','Kilos'),(2,'','Gramos'),(3,'','Litros'),(4,'','Mililitros'),(5,'','Unidades'),(6,'\0','Unidades'),(7,'\0','prueba');

/*Data for the table `pedido` */

insert  into `pedido`(`id`,`status`,`con_delivery`,`fecha`,`hora_estimada_fin`,`numero`,`precio_final`,`total`,`cliente_id`,`cocinero_id`,`delivery_id`,`pedido_domicilio_pedido`,`estado_pedido`,`factura_id`,`forma_pago_id`) values (1,NULL,'\0',NULL,'2020-07-30 21:36:13',0,0,0,6,NULL,NULL,NULL,4,NULL,NULL);

/*Data for the table `plato` */

insert  into `plato`(`id`,`status`,`denominacion`,`imagen`,`precio_venta`,`receta`,`tiempo_preparacion`,`plato_categoria_plato`) values (1,'','Agua saborizada','https://statics.dinoonline.com.ar/imagenes/full_600x600_ma/3040317_f.jpg',150,'No Aplica',0,2),(2,'','Red IPA','https://jumboargentina.vteximg.com.br/arquivos/ids/551145-750-750/Cerveza-Rabieta-Red-Ipa-473cc-1-819459.jpg?v=637063609845630000',260,'No Aplica',0,3),(3,'','Choripan','https://www.laylita.com/recetas/wp-content/uploads/Receta-del-choripan.jpg',200,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',20,1),(4,'','Hamburguesa doble','https://bk-latam-prod.s3.amazonaws.com/sites/burgerking.com.ar/files/bbq-bacon-doble.png',230,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',10,1),(5,'','Lomixto','https://truffle-assets.imgix.net/41c68cac-lomito_l_thumb.jpg',300,'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',40,1);

/*Data for the table `rol` */

insert  into `rol`(`id`,`status`,`denominacion`) values (1,'','COCINERO'),(2,'','CLIENTE'),(3,'','DELIVERY'),(4,'','CAJERO'),(5,'','GERENTE');

/*Data for the table `usuario` */

insert  into `usuario`(`tipo`,`id`,`status`,`apellido`,`email`,`nombre`,`telefono`,`password`,`dni`,`esta_activo`,`fecha_ingreso_empleado`,`cargo`,`usuario_rol`) values ('CLIENTE',1,'','Cattani','marcelocattani96@gmail.com','Marcelo',0,NULL,NULL,NULL,NULL,NULL,2),('DELIVERY',2,'','Diaz','delivery@gmail.com','Lucas',2612532896,NULL,NULL,NULL,NULL,NULL,3),('CAJERO',3,'','Olguin','cajero@gmail.com','Lautaro',26153296823,NULL,NULL,NULL,NULL,NULL,4),('GERENTE',4,'','Morales','gerente@gmail.com','Pedro',22614352619,NULL,NULL,NULL,NULL,NULL,5),('COCINERO',5,'','Monterrey','cocinero@gmail.com','Julian',2614359626,NULL,NULL,NULL,NULL,NULL,1),('CLIENTE',6,'','López','raami1999@gmail.com','Ramiro',0,NULL,NULL,NULL,NULL,NULL,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
