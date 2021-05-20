package net.hurelhuyag.demobench;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import net.hurelhuyag.demobench.models.DemoData;

import java.io.*;

/**
 * gson2string:   20784280357
 * gson2stream:   31990323311
 * jackson2string: 6260122921
 * jackson2stream: 7331952325
 */
public class Bench1 {

    private final Gson gson = new Gson();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private void gsonToString(){
        gson.toJson(DemoData.PET_STATES);
    }

    private void jacksonToString() {
        try {
            objectMapper.writeValueAsString(DemoData.PET_STATES);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private void gsonToStream() {
        gson.toJson(DemoData.PET_STATES, new OutputStreamWriter(OutputStream.nullOutputStream()));
    }

    private void jacksonToStream() {
        try {
            objectMapper.writeValue(OutputStream.nullOutputStream(), DemoData.PET_STATES);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void run(String name, Runnable method) throws Exception{
        System.out.print(name);
        System.out.print(",");
        System.gc();
        System.out.print("p,");
        System.in.read();
        System.out.print("s,");
        long start = System.nanoTime();
        for (int i=0; i<100_000; i++){
            method.run();
        }
        long end = System.nanoTime();
        System.out.println(",t:"+(end-start));
    }

    public Bench1() throws Exception {
        /*run("   gsonToString", this::gsonToString);*/
        /*run("   gsonToStream", this::gsonToStream);*/
        run("jacksonToString", this::jacksonToString);
        /*run("jacksonToStream", this::jacksonToStream);*/
    }

    public static void main(String[] args) throws Exception {
        new Bench1();
    }
}
