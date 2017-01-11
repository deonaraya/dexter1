package com.practice.automation.common;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by chandrad on 12/26/16.
 */
public class CommonHelper {

    public static String getPropData(String item) throws IOException {
        Properties prop = new Properties();
        InputStream input = CommonHelper.class.getClassLoader().getResourceAsStream("config.properties");
        prop.load(input);
        return prop.getProperty(System.getProperty("environment") + "." + item);
    }


    public static String getUniqueEmail(String name){
        String value = name + new SimpleDateFormat("ss").format(new Date()) + "@mailinator.com";
        return value;
    }

    public static Map<String,String> getExcelData() throws IOException, BiffException {
        Map<String, String> dataMap = new HashMap<String, String>();
        Workbook workbook = Workbook.getWorkbook(new java.io.File("/Users/chandrad/Documents/DeoTrainings/dexter1/src/main/resources/TestData.xls"));
        Sheet sheet = workbook.getSheet(0);
        int rowcount = sheet.getRows();
        int columnCount = sheet.getColumns();
        System.out.println("row = " + rowcount + "column = " + columnCount);

        for (int j = 1; j <  rowcount; j++) {


            for (int i = 0; i < columnCount; i++) {

                Cell mapKey = sheet.getCell(i, 0);
                Cell mapVaues = sheet.getCell(i, j);


                if (mapKey.getContents() != "") {
                    dataMap.put(mapKey.getContents(), mapVaues.getContents());
                 //   System.out.println("Input VariableName: " + mapKey.getContents() + " Variable Value from Excel::" + mapVaues.getContents());
                } else
                    break;
            }
        }

        System.out.print(dataMap);

//        for(int i=0;i<columnCount;i++)
//        {
//            Cell ObjectName = sheet.getCell(i, 0);
//
//         //   System.out.println("test chandra " + ObjectName.getContents());
//
//
//            Cell ObjectValue = sheet.getCell(i,i);
//            if(ObjectName.getContents()!="")
//            {
//                dataMap.put(ObjectName.getContents(), ObjectValue.getContents());
//                System.out.println("Input VariableName: "+ObjectName.getContents()+" Variable Value from Excel::"+ ObjectValue.getContents() );
//            }
//            else
//                break;
//        }

        return dataMap;
    }

    @Test
    public void dd(){
        System.out.println(getUniqueEmail("chandra"));
        try {
            getExcelData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

    }


}