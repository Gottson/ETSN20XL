package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import util.XLException;

public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    public void load(Map<String, Slot> map, SlotFactory slotFactory) {
    	map.clear();
        try {
            while (ready()) {
                String string = readLine();
                String[] strings = string.split("=");               
                map.put(strings[0], slotFactory.slot(strings[1]));
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
