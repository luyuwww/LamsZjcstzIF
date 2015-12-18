package com.lams.pojo;

import java.io.Serializable;

public class SUserWithBLOBs extends SUser implements Serializable {
    private byte[] ini;

    private byte[] inixml;

    private static final long serialVersionUID = 1L;

    public byte[] getIni() {
        return ini;
    }

    public void setIni(byte[] ini) {
        this.ini = ini;
    }

    public byte[] getInixml() {
        return inixml;
    }

    public void setInixml(byte[] inixml) {
        this.inixml = inixml;
    }
}