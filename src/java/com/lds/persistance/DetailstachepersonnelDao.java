
package com.lds.persistance;

import com.lds.vo.Detailstachepersonnel;
import com.lds.vo.DetailstachepersonnelId;
import java.util.List;
/**
 *
 * @author ELKAOUMI
 */
public interface DetailstachepersonnelDao {
    public List getAllDetailstachepersonnel();

    public Detailstachepersonnel getDetailstachepersonnel(DetailstachepersonnelId id);

    public void update(Detailstachepersonnel detailstachepersonnel);

    public void insert(Detailstachepersonnel detailstachepersonnel);

    public void delete(DetailstachepersonnelId id);
    
}
