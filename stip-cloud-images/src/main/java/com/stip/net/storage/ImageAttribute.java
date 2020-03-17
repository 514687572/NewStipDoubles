package com.stip.net.storage;

import lombok.Data;

/**
 * @author wangzun
 * @version 2019/4/24 上午9:16
 * @desc
 */
@Data
public class ImageAttribute {

    private String path;
    private String fileName;
    private String fileHash;
    private byte[] imgBytes;

    private float defaultQuality = 0.75f;
    private int[] horizontalSamp = new int[4];
    private int[]               verticalSamp   = new int[4];
    private boolean             qualitySet     = false;
    private boolean             samplingSet    = false;
    private QuantAlgorithm      quantAlgorithm = QuantAlgorithm.OctTree;

    public enum QuantAlgorithm {
        OctTree, NeuQuant, MedianCut
    }
}
