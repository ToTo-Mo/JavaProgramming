package Syntax.Mutex;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.*;

public class SequenceGenerator {

    private int currentValue =0;

    public int getNextSequence(){
        return ++currentValue;
    }

    
}