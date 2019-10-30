package edu.cscc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Census {
    /**
     * surname
     * @param fname
     * @return namelist
     */
    public static Surname[] loadCensusData(String fname) throws FileNotFoundException {
        int line = 0; // Keep track of lines of file we've read
        Surname[] namelist = new Surname[100];
        {
            //declaration
            String name;
            int rank, count;
            double proportion;
            /**
             *author kyria mba chendjou
             */
            File file = new File(fname);
            try (Scanner input = new Scanner(file);) {
                input.nextLine(); //skip the first line
                while (input.hasNext() && line<100) {
                    String s = input.nextLine();
//split
                    String ky []= s.split(",");
                    name= ky[0];
                    rank= Integer.parseInt(ky[1]);
                    count= Integer.parseInt(ky[2]);
                    proportion= Double.parseDouble(ky[3]);

                    namelist[line]= new Surname(name,rank,count,proportion);

                    line++;
                    System.out.println(s);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Cannot access file" + fname);
            }
        }
            return namelist;
        }
    }