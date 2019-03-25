package kr.co.woobi.imyeon.networkexam;

import kr.co.woobi.imyeon.networkexam.model.Photo;

public class EventImageResize {
    Photo photo;

    public EventImageResize(Photo photo) {
        this.photo = photo;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("EventImageResize{");
        sb.append("photo=").append(photo);
        sb.append('}');
        return sb.toString();
    }
}
