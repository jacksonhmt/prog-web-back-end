package br.edu.unievangelica.domain.coupon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    public Coupon findCouponByNameIgnoreCase(String couponName);
}
