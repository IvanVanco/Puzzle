#                                              Puzzle(Slagalica)
Simulation of the Serbian game called Slagalica,
where player chooses 12 letters of an alphabet from random generator, and then
during the specific time, they need to make longest word to win.


# What are new

1. Code is organized with MCV arhitecture in mind with few exeptions. Views are stored in views package and are independant of other parts. Models are built with bussiness logic and are stored in model package. Engine classes are one that cannot have standard MVC logic and are separated from other classes. They are heart of project.

2. Builded API around newly added serbian dictionary from Milan_Vujaklija_-_Leksikon_stranih_reci.pdf file.
   I used different tools for extracting words with bolded text, and Microsoft Word software is showed as decent option. 
   This dictonary is only start up and have like 35000 words. 
   Note: I have plan for integrationg Google Translate API support for identifying existance and correctness of the words. 

3. Algorithm for finding longest possible words from given letters, only using plain old java without single one libraby.

4. Updated Message Engine system (PorukeEngine with various message controllers) with good future flexibility for reporting and working    with game results. 

5. Logic model for word scoring points. 

6. Data repositories part for storing dictionary and probability data.

7. API for converting latin to cyrilic.

8. Reworked probability model for drawing semi-random letters with flexibility options in mind. 

9. Various abstractions models are added and updated. 

10. Performance of application is made sharper.

11. Modified and better organized legacy code and packages with logical background.

12. Fixed few bugs from main view and some model classes.



# Future work
This will be good project for learning and building Clojure version of it which have great integration capabilities with Java and JVM. 
It will be good practical comparison and i will try to point different benefits of using it.   


# Testing it out
Open some of Java IDEs like Idea InteliiJ or Eclipse, and choose to open existing project. Application need to be rebuild for .jar executable file. 
