/*Album*/
INSERT INTO album(id, nombre, path_img)
VALUES(1, "Back in Black", "img/Album/BackInBlack.jpg"),
	  (2, "Medicine at Midnight", "img/Album/MedicineAtMidnight.jpg");
      
/*Artista*/
INSERT INTO artista(id, nombre)
VALUES(1, "AC/DC"),
      (2, "Foo Fighters");
      
/*Genero por el momento no se esta utilizando*/
INSERT INTO genero(id, nombre)
VALUES(1, "rock");

/*Canciones*/
INSERT INTO cancion(id, nombre, path_cancion, album_id, artista_id, puntaje)
VALUES(1, "Hells Bells", "media/BackInBlack/Hells Bells.mp3",1 ,1 , 500),
      (2, "Shoot to Thrill", "media/BackInBlack/Shoot to Thrill.mp3",1 ,1 , 10),
      (3, "What Do You Do for Money Honey", "media/BackInBlack/What Do You Do for Money Honey.mp3",1 ,1 , 60),
      (4, "Givin the Dog a Bone", "media/BackInBlack/Givin the Dog a Bone.mp3",1 ,1 , 20),
      (5, "Let Me Put My Love Into You", "media/BackInBlack/Let Me Put My Love Into You.mp3",1 ,1 , 400),
      (6, "Back In Black", "media/BackInBlack/Back In Black.mp3",1 ,1 , 50),
      (7, "You Shook Me All Night Long", "media/BackInBlack/You Shook Me All Night Long.mp3",1 ,1 , 30),
      (8, "Have a Drink on Me", "media/BackInBlack/Have a Drink on Me.mp3",1 ,1 , 200),
      (9, "Shake a Leg", "media/BackInBlack/Shake a Leg.mp3",1 ,1 , 150),
      (10, "Rock and Roll Ain't Noise Pollution", "media/BackInBlack/Rock and Roll Ain't Noise Pollution.mp3",1 ,1 , 70),
      (11, "Making A Fire", "media/Medicine at midnight/Making A Fire.mp3",2 ,2 , 300),
      (12, "Shame Shame", "media/Medicine at midnight/Shame Shame.mp3",2 ,2 , 80),
      (13, "Cloudspotter", "media/Medicine at midnight/Cloudspotter.mp3",2 ,2 , 90),
      (14, "Waiting On A War", "media/Medicine at midnight/Waiting On A War.mp3",2 ,2 , 5),
      (15, "Medicine At Midnight", "media/Medicine at midnight/Medicine At Midnight.mp3",2 ,2 , 7),
      (16, "No Son Of Mine", "media/Medicine at midnight/No Son Of Mine.mp3",2 ,2 , 100),
      (17, "Holding Poison", "media/Medicine at midnight/Holding Poison.mp3",2 ,2 , 8),
      (18, "Chasing Birds", "media/Medicine at midnight/Chasing Birds.mp3",2 ,2 , 9),
      (19, "Love Dies Young", "media/Medicine at midnight/Love Dies Young.mp3",2 ,2 , 9);  
      
/*Inserta usuario*/
INSERT INTO usuario(id, usuario, password, rol)
VALUES(1, "ivank", "1234", "usuario"),
      (2, "godiee", "zxcv", "usuario");
      
/*Añadir a favoritos*/
INSERT INTO favorito(id, cancion_id, usuario_id)
VALUES(1 ,19, 2),
      (2 ,16 ,2);      
      