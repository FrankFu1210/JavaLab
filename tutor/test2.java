if(x%4 == 0) {
	if(x% 100 == 0) {
		if(x% 400 == 0) {
			System.out.println("閏年");
		}else System.out.println("平年");
	}else System.out.println("閏年");
}else System.out.println("平年");
