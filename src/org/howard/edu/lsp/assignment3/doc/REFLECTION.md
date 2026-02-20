# Reflection - Assignment 3: Object-Oriented ETL Pipeline

## 1. Design Differences Between Assignment 2 and Assignment 3
In Assignment 2, the ETL pipeline was structured in a procedural manner, where the extraction, transformation, and loading were handled in a single block of code. In Assignment 3, I refactored the pipeline into three separate classes: Extractor, Transformer, and Loader, each responsible for a specific task. This change allowed for better organization, easier maintenance, and clearer code.

## 2. Object-Oriented Principles Used
### Encapsulation
Each class in Assignment 3 encapsulates its own logic. The Extractor class handles file reading and stores the source path and the Loader class is responsible for writing the transformed data.

### Inheritance
I didn't use inheritance explicitly in this assignment, because each class had a unique responsibility. I could have used it if I had more diverse data extraction sources.

### Polymorphism
While I didn't use polymorphism in this case, if I had multiple types of extractors, polymorphism could be used to have a common interface for extractData().

## 3. Testing and Verification
I tested the pipeline by comparing the output of the object-oriented version to that of Assignment 2. I also verified edge cases, like empty input files, to ensure the program handles errors nicely.

