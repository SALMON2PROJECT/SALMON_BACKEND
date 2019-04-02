package dkproparent;

import java.rmi.Remote;

/**
 * Created by pooya_hy on 11/1/2018.
 */
public interface DKProparent extends Remote  {
     String getText(String url)throws Exception;
}
