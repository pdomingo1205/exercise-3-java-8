package com.act3;

import java.util.stream.*;
import java.util.*;
import java.util.concurrent.*;
import java.time.LocalTime;

public class HorseRace{


	//tryforgit

	private Stream<Horse> horseStream;
	private List<Horse> horseList;
	private static int field;


	InputUtilities console = new InputUtilities();

	public HorseRace(List<Horse> horseArray, int newField){
		horseList = horseArray;
		field = newField;
	}





	public void toParallel(){
		horseStream = horseList.parallelStream();
	}

	public void start() {

		try{

			toParallel();
			ForkJoinPool forkJoinPool = new ForkJoinPool(horseList.size());
			forkJoinPool.submit( () ->	horseStream.forEach(horse -> {
				runToGoal(horse, 10, "Barn");
			})).get();

			console.printLine("\n \t -----START----- \n");

			toParallel();

			forkJoinPool.submit( () ->
				horseStream.forEach(horse -> {
				System.out.println("\n" + Thread.currentThread().getName() + " " + LocalTime.now() + "\n");
				runToGoal(horse, field, "finish");
			})).get();

			horseList.stream().forEach(horse -> {
					System.out.println(String.format(" %s travelled Distances: %s = %d ", horse.getName(), horse.getDistBreakDown(), horse.getDistanceTravelled()));
				}
			);


		}
		catch(InterruptedException | ExecutionException ie){

		}

	}

	public void cry(Horse horse){
		Optional<String> warCry = horse.getWarCry();
		String horseName = horse.getName();

		if (warCry.isPresent()){
			console.printLine(String.format("\n %s shouts \"%s\" \n", horseName, warCry.get()));
		}else {
			console.printLine(String.format("\n %s has no warcry. \n", horseName));
		}

	}

	public Horse run(Horse horse, int max){
		int tempSpeed = console.randomNumber(1, max - 1);

		horse.setSpeed(tempSpeed);
		horse.setDistanceTravelled(horse.getDistanceTravelled() + tempSpeed);

		return horse;
	}

	public void runToGoal(Horse horse, int distance, String dest){

		horse.setDistRemain(distance);

		do {

			if (horse.getDistRemain() < 10){
				horse = run(horse, horse.getDistRemain());
			}
			else {
				horse = run(horse, 10);
			}

			horse.setDistRemain(distance - horse.getDistanceTravelled());
			horse.addDistBreakDown(horse.getSpeed());

			if (dest.equals("Barn")) {
				System.out.println(String.format(" %s Distance Left to barn: %d meters ", horse.getName(), horse.getDistRemain()));
			}
			else{
				System.out.println(String.format(" %s has galloped: %d meters	|	Distance Traversed: %d meters 	|	Distance Left: %d meters",
												horse.getName(), horse.getSpeed(), horse.getDistanceTravelled(), horse.getDistRemain()));
			}

		} while (horse.getDistanceTravelled() < distance);

		if (dest.equals("Barn")) {
			horse.setDistanceTravelled(0);
			System.out.println("\n" + horse.getName() + " has reached the Barn! \n");
		} else {
			cry(horse);
		}

	}



}
