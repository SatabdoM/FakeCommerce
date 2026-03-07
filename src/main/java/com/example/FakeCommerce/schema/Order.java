package com.example.FakeCommerce.schema;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseEntity {
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}
// OneToMany: One order can have many order items
// mappedBy: This attribute specifies the field in the OrderItem entity that owns the relationship.
// cascade: This attribute specifies the cascade operations that should be applied to the related entities.
// CascadeType.ALL: This means that all cascade operations (persist, merge, remove, refresh, detach) will be applied to the related OrderItem entities when they are performed on the Order entity.

