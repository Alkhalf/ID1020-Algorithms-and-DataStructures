/*@author Ahmed Alkhalaf
Task 1 i labb 3
Koden är en enkel filter programm från alla teckan och tal som är inte
bokstäver eller ny rad. Tecken somtas bort ersättar med mellansrad istället.
Koden gjorde helt på egenhand med diskussion mellan klasskamrater
Koden skapade den 2021/09/29
Sista upptadering 2021/10/04
*/
# include <stdio.h>
# include <ctype.h>
int main() {
 //Öppna filer:
 FILE *filereader = fopen("the_text.txt", "r"); // read från filen
 FILE *filerwriter = fopen("filter.txt", "w"); // write till filen
 if (filereader==NULL || filerwriter==NULL)
 printf("Eror, one or two of the files is not exist\n");
 //läsa en bokstav från filen och spara i variabel ch
 char ch = getc(filereader);
 //EOF kontrollerar slutet av filen
 while ( ch != EOF){
 //byta ut alla char så länge de är inte new line eller är inte bokstäver
 if ( !isalpha(ch) && ch != '\n' )
 ch = ' ';
 //skriva ut på filen
 fprintf(filerwriter,"%c",ch);
 //Läs från filen igen
 ch =getc(filereader);
 }
 fclose(filereader);
 fclose(filerwriter);
 printf("Filtering is done check filter.txt file!\n");
}