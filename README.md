# SimRace

Car race simulation in Java to practice multithreading. Each car runs as its own thread and drives a number of laps with random lap times. The main thread waits for all cars with `join()` and then prints the final ranking sorted by total time.

Team project in the course Computer Networks & Operating Systems at HAW Hamburg.

## Concepts

- `Runnable` and `Thread` (one thread per car)
- `Thread.sleep()` for simulated lap times
- `join()` to wait for all threads
- Sorting the results with Streams and `Comparator`

## Tech

Java 21, Maven

## Running

Open the project in IntelliJ and run `Main`. By default 5 cars race for 10 laps; both values can be changed in `Main.java`.
