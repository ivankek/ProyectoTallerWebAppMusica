use db_proyecto;
/*Album*/
INSERT INTO album(id, nombre, path_img)
VALUES(1, "Back in Black", "img/Album/BackInBlack.jpg"),
	  (2, "Medicine at Midnight", "img/Album/MedicineAtMidnight.jpg"),
      (3, "Thriller", "img/Album/Thriller.jpg"),
      (4, "Dynasty", "img/Album/Dynasty.jpg");
      
/*Artista*/
INSERT INTO artista(id, nombre, path_img)
VALUES(1, "AC/DC" , "img/Artista/ac_dc.jpg"),
      (2, "Foo Fighters" , "img/Artista/foo_fighters.jpg"),
      (3, "Michael Jackson", "img/Artista/michael_jackson.jpg"),
      (4, "Kiss", "img/Artista/kiss.jpg");

/*Genero*/
INSERT INTO genero(id, nombre)
VALUES(1, "rock"),
      (2, "pop");

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
      (19, "Love Dies Young", "media/Medicine at midnight/Love Dies Young.mp3",2 ,2 , 9),
      (20, "Wanna Be Startin' Somethin'" , "media/Thriller/01 - Wanna Be Startin' Somethin'.mp3", 3, 3,0),
      (21, "Baby Be Mine" , "media/Thriller/02 - Baby Be Mine.mp3", 3, 3,0),
      (22, "The Girl Is Mine" , "media/Thriller/03 - The Girl Is Mine.mp3", 3, 3,0),
      (23, "Thriller" , "media/Thriller/04 - Thriller.mp3", 3, 3,0),
      (24, "Beat It" , "media/Thriller/05 - Beat It.mp3", 3, 3,0),
      (25, "Billie Jean" , "media/Thriller/06 - Billie Jean.mp3", 3, 3,0),
      (26, "Human Nature" , "media/Thriller/07 - Human Nature.mp3", 3, 3,0),
      (27, "P.Y.T. (Pretty Young Thing)" , "media/Thriller/08 - P.Y.T. (Pretty Young Thing).mp3", 3, 3,0),
      (28, "The Lady In My Life" , "media/Thriller/09 - The Lady In My Life.mp3", 3, 3,0), 
      (29, "I Was Made For Lovin You" , "media/Dynasty/IWasMadeForLovinYou.mp3", 4, 4,0),
      (30, "Sure Know Something" , "media/Dynasty/SureKnowSomething.mp3", 4, 4,0);  
      
/*Asociar cancion a los generos*/
INSERT INTO canciongenero(id , cancion_id , genero_id)
VALUES(1 , 1 , 1),
	  (2 , 2 , 1),
	  (3 , 3 , 1),
	  (4 , 4 , 1),
	  (5 , 5 , 1),
	  (6 , 6 , 1),
	  (7 , 7 , 1),
	  (8 , 8 , 1),
	  (9 , 9 , 1),
	  (10 , 10 , 1),
	  (11 , 11 , 1),
	  (12 , 12 , 1),
	  (13 , 13 , 1),
	  (14 , 14 , 1),
	  (15 , 15 , 1),
	  (16 , 16 , 1),
	  (17 , 17 , 1),
	  (18 , 18 , 1),
	  (19 , 19 , 1),
      (20 , 20 , 2),
      (21 , 21 , 2),
      (22 , 22 , 2),
      (23 , 23 , 2),
      (24 , 24 , 2),
      (25 , 25 , 2),
      (26 , 26 , 2),
      (27 , 27 , 2),
      (28 , 28 , 2),
      (29, 29, 1),
      (30, 30, 1);
      
/*Inserta usuario*/
INSERT INTO usuario(id, usuario, password, rol, path_img)
VALUES(1, "ivank", "1234", "usuario", "img/Usuario/ricky.jpg"),
      (2, "godiee", "zxcv", "usuario", null),
      (3, "ezeew", "9876", "usuario", null),
      (4, "juampif", "abcd", "usuario", null);
      
/*Añadir a favoritos*/
INSERT INTO favorito(id, cancion_id, usuario_id)
VALUES(1 ,19, 2),
      (2 ,16 ,2);      
      