package guava;

import com.google.common.util.concurrent.AbstractExecutionThreadService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/3/10
 */
public class ExecutorThreadServiceImpl extends AbstractExecutionThreadService {

    private Map<String, ExecutorThreadServiceImpl> poolMap = new ConcurrentHashMap();




    @Override

    protected void run() throws Exception {

    }
}
