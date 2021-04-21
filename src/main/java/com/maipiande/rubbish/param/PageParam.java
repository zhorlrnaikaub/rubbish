package com.maipiande.rubbish.param;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageParam {

    private int pageNum = 1;

    private int pageSize = 10;
}
