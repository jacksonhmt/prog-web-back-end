package br.edu.unievangelica.domain.coupon;

import br.edu.unievangelica.core.exception.CustomInternalException;
import br.edu.unievangelica.core.exception.CustomNotFoundException;
import br.edu.unievangelica.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService extends AbstractService<Coupon> {
    @Autowired
    CouponRepository couponRepository;

    public Coupon findCouponByName (String couponName) {
        Coupon coupon = couponRepository.findCouponByNameIgnoreCase(couponName);
        System.out.println("Service...");
        if(coupon.getIsUsed() == false) {
            coupon.setIsUsed(true);
            return couponRepository.save(coupon);
        }
        throw new CustomInternalException("");
    }
}
