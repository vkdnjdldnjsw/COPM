/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.manager.data;

import java.io.Serializable;

/**
 *
 * @author Arsene holmes
 */
public class NickNameData extends NetworkData implements Serializable {
    private String nickName;

    public NickNameData(String nickName) {
        super(NetworkData.CONNECT);
        this.nickName = nickName;
    }
    public String getNickName(){
        return nickName;
    }
}
