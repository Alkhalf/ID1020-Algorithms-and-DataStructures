/*@author Ahmed Alkhalaf
* Koden har skapat den 2021/09/05
* sista uptadering av koden har gjort den 2021/09/14
* Koden har gjort på egenhand med hjälp av kurslitteratur och diskussionen med andra
klasskamrater */
# include <stdio.h>
void recrusivFunction ( ){
char charecter;
if((charecter = getchar()) == '\n') {}
else{
recrusivFunction(); putchar (charecter); }
}
int main(){
printf ("Enter a word \n" ); recrusivFunction(); printf("\n");
return 0;
}
