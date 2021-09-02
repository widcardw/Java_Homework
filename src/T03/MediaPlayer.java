package src.T03;

public interface MediaPlayer {
    public abstract void decode();  // 解码
    public abstract void encode();  // 编码
    public abstract void pixFmt();  // 色彩空间
    public abstract void codec();   // 编解码
    public abstract void format();  // 封装格式
    public abstract void filter();  // 滤镜
    public abstract void colors();  // 色彩
    public abstract void muxers();  // 视频复用器(整流器)
    public abstract void demuxers();// 分流器
    public abstract void size();    // 视频尺寸
    public abstract void subtitles(); // 字幕
    public abstract void play(String src);
}

class MPEGPlayer implements MediaPlayer {

    @Override
    public void decode() {
        // TODO Auto-generated method stub

    }

    @Override
    public void encode() {
        // TODO Auto-generated method stub

    }

    @Override
    public void pixFmt() {
        // TODO Auto-generated method stub

    }

    @Override
    public void codec() {
        // TODO Auto-generated method stub

    }

    @Override
    public void format() {
        // TODO Auto-generated method stub

    }

    @Override
    public void filter() {
        // TODO Auto-generated method stub

    }

    @Override
    public void colors() {
        // TODO Auto-generated method stub

    }

    @Override
    public void muxers() {
        // TODO Auto-generated method stub

    }

    @Override
    public void demuxers() {
        // TODO Auto-generated method stub

    }

    @Override
    public void size() {
        // TODO Auto-generated method stub

    }

    @Override
    public void subtitles() {
        // TODO Auto-generated method stub

    }
    
    @Override
    public void play(String src) {
        System.out.println("Playing " + src + " with MPEG Player...");
    }
}