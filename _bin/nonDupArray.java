		// Creating a non-duplicated array using LinkedHashSet object.
		LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>(SIZE);
		
		for (int i = 0; i < SIZE; i++)
			lhs.add((int)(Math.random() * (SIZE * SIZE)));
		
		System.out.println(lhs);
		
		Iterator<Integer> itr = lhs.iterator();
		int index = 0;
		while(index < SIZE && itr.hasNext())
			temperature[index++] = itr.next();
		
		// Enhanced for-loop that works with arrays.
		System.out.print("[");
		for(int i : temperature)
			System.out.print(i + ", ");
		System.out.println("]");