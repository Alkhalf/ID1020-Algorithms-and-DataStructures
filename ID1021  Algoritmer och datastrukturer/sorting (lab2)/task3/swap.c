/*@author Ahmed Alkhalaf
Task 3 i labb 2
negativa tal och positiva tal i en array utan hänsyn till ordning
på tal däremot bara separera negativa tal i de första indexer och
positiva tal i de sista indexer av array.
Ingen sortering algoritm är använd för denna uppgiften.
Koden gjorde på egenhand med diskussion mellan klasskamrater
Koden skapade den 2021/09/22
Sista uppdatering 2021/09/25
*/
# include <stdio.h>
void swap (int numbersArray[], int right, int left) {
 int temp;
 temp= numbersArray[left];
 numbersArray[left]=numbersArray[right];
 numbersArray[right]=temp;
}
int main(){
 int arrayLength,j,z=0;
 printf ("How many numbers do you want to enter? \n" );
 scanf("%d", &arrayLength);
 int numbers[arrayLength];
 printf ("Enter the numbers \n" );
 for (int i=0; i <= arrayLength-1; i++){
 scanf("%d", &numbers[i]);
 }
 j=arrayLength-1;
 while(z<=j){
 //- -
 if (numbers[z]< 0 && numbers[j]< 0 ){
 z++;
 }
 //- +
 else if( numbers[z] < 0 && numbers[j] > 0 ){
 z++;
 j--;
 } 
 //+ -
 else if( numbers[z]> 0 && numbers[j]< 0 ){
 swap(numbers, z, j);
 z++;
 j--;
 }
 //+ -
 else if( numbers[z] > 0 && numbers[j]>0 ){
 j--;
 }
 }
 printf("\n");
 for (int i=0; i< arrayLength; i++){
 printf("[%d]", numbers[ i ]);
 }
 printf("\n");
}