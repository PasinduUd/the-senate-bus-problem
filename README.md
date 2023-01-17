<h1 align="center"> The Senate Bus Problem </h1>  

7.4 - The Senate Bus Problem (The Little Book of Semaphores - Allen B. Downey - Version 2.1.5) (Page 211)  

[Github Repo](https://github.com/PasinduUd/the-senate-bus-problem)

## Prerequisites

JDK 1.8 or Higher

## Compile and Run the Program

Go to the root folder of the project and open the command prompt. Then use the commands given below to compile and run the code.

**Compile**  
`javac -d temp src/*.java`

**Run**    
`java -cp temp Main`

## Screenshots of Output

**1) Start of the program**  

![Start of the program](./Output%20Screenshots/1%20-%20Start%20of%20the%20program.png?raw=true "Start of the program")

**2) Bus arrived when 15 riders are waiting at the bus stop**  

![Bus arrived when 15 riders are waiting](./Output%20Screenshots/2%20-%20Bus%20arrived%20when%2015%20riders%20are%20waiting.png?raw=true "Bus arrived when 15 riders are waiting")

**3) Bus arrived when 76 riders (> maximum riders per bus = 50) are waiting at the bus stop**  

![Bus arrived when 76 riders are waiting](./Output%20Screenshots/3%20-%20Bus%20arrived%20when%2076%20riders%20are%20waiting.png?raw=true "Bus arrived when 76 riders are waiting")

**4) Bus departed with 50 riders (Remaining riders = 76 -50 = 26)**  

![Bus departed with 50 riders (Remaining 26)](./Output%20Screenshots/4%20-%20Bus%20departed%20with%2050%20riders%20(Remaining%2026).png?raw=true "Bus departed with 50 riders (Remaining 26)")

**5) Bus arrived when no riders are waiting at the bus stop and departed immediately**  

![Bus arrived when 0 riders are waiting and departed immediately](./Output%20Screenshots/5%20-%20Bus%20arrived%20when%200%20riders%20are%20waiting%20and%20departed%20immediately.png?raw=true "Bus arrived when 0 riders are waiting and departed immediately")
