Hello, thanks for reading the file.

The functionality is basically to take files (txt or csv) from a path, read them, sort them and take a file with the ordered output.

For the jar to work, the following steps must be taken:

1. Download the jar file in a convenient path or that you want (SampleProjectPlanet-0.0.1-SNAPSHOT.zip)
2. Create 4 folders in root path:
1. name: applogs
2. within applogs, name: files
3. within files 2 folders, names: file and output

The routes should look like this
/ applogs /
/ applogs / files /
/ applogs / files / archive
/ applogs / files / output

3. The files you want to process must have a txt or csv extension and place them in the path: / applogs / files /

4. To run the jar you must open a cmd and go to the path where the jar was placed
Example: C: \ Users \ MXE01021179A \ Download \ SampleProjectPlanet-0.0.1-SNAPSHOT.jar


The jar has a "menu" for the options you want. The jar receives 2 parameters,
The first is the type of file to be processed, it has 3 options: MENU_PROCESS_ALL, MENU_PROCESS_FILE_CSV or MENU_PROCESS_FILE_ASCII
The second is the type of ordering you want: ORDER_FIRST_NAME, ORDER_LAST_NAME, ORDER_START_DATE


If any of the parameters is not sent correctly, the jar will not process what is indicated.


Example: java -jar SampleProjectPlanet-0.0.1-SNAPSHOT.jar MENU_PROCESS_FILE_CSV ORDER_LAST_NAME
What it will do is read the files that are in the /applogs/files/*.csv path and if they exist it will process them and order them by LAST_NAME.


The folder sample_files has a sample files, txt and csv


Author: Danito - skaline123@gmail.com