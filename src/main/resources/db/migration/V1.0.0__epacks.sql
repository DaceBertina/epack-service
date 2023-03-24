
use epacks;

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE epacks (
                       epack_id int NOT NULL AUTO_INCREMENT,
                       category_id int,
                       epack_name varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
                       description text,
                       price decimal NOT NULL DEFAULT 0,
                       manager_id bigint(20),
                       date_created datetime NOT NULL,
                       last_updated datetime NOT NULL,
                       is_active boolean,
                       order_id bigint(20),
                       PRIMARY KEY (epack_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


CREATE TABLE categories (
                          category_id int NOT NULL AUTO_INCREMENT,
                          category_name varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
                          date_created datetime NOT NULL,
                          last_updated datetime NOT NULL,
                          PRIMARY KEY (category_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;