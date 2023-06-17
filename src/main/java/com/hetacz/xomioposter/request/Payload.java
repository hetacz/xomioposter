package com.hetacz.xomioposter.request;

import com.hetacz.xomioposter.constants.Language;
import com.hetacz.xomioposter.constants.OperatingSystem;
import com.hetacz.xomioposter.constants.Resolution;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

public record Payload(int v, String tid, String gtm, int _p, String cid, String ul, String sr, String uaa, int uab,
        String uafvl, int uamb, @Nullable String uam, String uap, String uapv, int uaw, int ngs, int _s, int sid,
        int sct, int seg, String dl, String dr, String dt, String en, int _ee,
        /*@JsonProperty("ep.event_category")*/String ep_event_category, /*@JsonProperty("ep.event_action")*/
        String ep_event_action, /*@JsonProperty("ep.event_label")*/String ep_event_label, /*JsonProperty("epn.value")*/
        int epn_value, int _et) implements Serializable {

    public static Payload of(String gtm, int _p, String cid, Language language, Resolution resolution, String secchua, OperatingSystem operatingSystem, /*ngs*/, int sid, int sct, int seg, TargetHost targetHost, TrackedEvent trackedEvent, int _et) {
    }

    }

}
