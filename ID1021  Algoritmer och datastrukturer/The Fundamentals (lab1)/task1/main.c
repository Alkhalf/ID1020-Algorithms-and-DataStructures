/*@author Ahmed Alkhalaf
* Koden har skapat den 2021/09/05
* sista uppdatering av koden har gjort den 2021/09/14
* Koden har gjort på egenhand med hjälp av kurslitteratur och diskussionen med andra
klasskamrater */
#include <stdio.h> 
int main()
{
char word [10];
char charecter;
int i, j, count=0;
printf ("Enter a word \n" );
while( (charecter = getchar()) != '\n') {
word[count]=charecter;
 
count++; }
char revers[count]; while(count !=0)
{
revers [j]= word[count-1]; putchar (revers[j]); count--;
j++;
}
printf ("\n"); return 0;
}