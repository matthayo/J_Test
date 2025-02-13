#include <stdio.h>
#include <stdlib.h>

int main(){
	int arr[2];
	arr[0] = 3;
	arr[1] = 5;
	for(int i = 0; i < 5; i++)
		printf( "arr[%d] = %d\n", i, arr[i] );
}