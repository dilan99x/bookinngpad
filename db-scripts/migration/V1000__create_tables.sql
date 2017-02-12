--
-- Table structure for user
--
CREATE TABLE user (
  user_id              INT UNSIGNED NOT NULL AUTO_INCREMENT,
  username             VARCHAR(250) NOT NULL,
  email                VARCHAR(250) NOT NULL,
  is_active            TINYINT(1),
  is_sysadmin          TINYINT(1),
  password             VARCHAR(250),
  otp_code             VARCHAR(250),
  password_reset_token VARCHAR(250),
  PRIMARY KEY (user_id),
  UNIQUE (email)
)
  ENGINE = InnoDB;

--
-- Table structure for authority
--

CREATE TABLE authority (
  authority_id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
  authority_name VARCHAR(50)  NOT NULL,
  PRIMARY KEY (authority_id)
)
  ENGINE = InnoDB;

--
-- Table structure for user_authority
--

CREATE TABLE user_authority (
  user_id      INT UNSIGNED NOT NULL,
  authority_id INT UNSIGNED NOT NULL,
  PRIMARY KEY (user_id, authority_id),
  FOREIGN KEY (user_id) REFERENCES user (user_id),
  FOREIGN KEY (authority_id) REFERENCES authority (authority_id),
  UNIQUE INDEX user_authority_idx_1 (user_id, authority_id)
)
  ENGINE = InnoDB;

--
-- Table structure for oauth_access_token
--

CREATE TABLE oauth_access_token (
  oauth_access_token_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  token_id              VARCHAR(256)          DEFAULT NULL,
  token                 BLOB,
  authentication_id     VARCHAR(256)          DEFAULT NULL,
  user_name             VARCHAR(256)          DEFAULT NULL,
  client_id             VARCHAR(256)          DEFAULT NULL,
  authentication        BLOB,
  refresh_token         VARCHAR(256)          DEFAULT NULL,
  PRIMARY KEY (oauth_access_token_id)
)
  ENGINE = InnoDB;

--
-- Table structure for oauth_refresh_token
--

CREATE TABLE oauth_refresh_token (
  oauth_refresh_token_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  token_id               VARCHAR(256)          DEFAULT NULL,
  token                  BLOB,
  authentication         BLOB,
  PRIMARY KEY (oauth_refresh_token_id)
)
  ENGINE = InnoDB;

--
-- Table structure for location
--

CREATE TABLE location (
  location_id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
  location_code VARCHAR(50),
  district      VARCHAR(50),
  province      VARCHAR(20),
  PRIMARY KEY (location_id)
)
  ENGINE = InnoDB;

--
-- Table structure for activity_property
--

CREATE TABLE activity_property (
  activity_property_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  property_code        VARCHAR(50),
  is_valid             TINYINT(1),
  property_description VARCHAR(100),
  PRIMARY KEY (activity_property_id)
)
  ENGINE = InnoDB;

--
-- Table structure for activity_type
--

CREATE TABLE activity_type (
  activity_type_id     INT UNSIGNED NOT NULL AUTO_INCREMENT,
  activity_type_code   VARCHAR(50),
  is_active            TINYINT(1),
  property_description VARCHAR(50),
  PRIMARY KEY (activity_type_id)
)
  ENGINE = InnoDB;

--
-- Table structure for organization_type
--

CREATE TABLE organization_type (
  organization_type_id     INT UNSIGNED NOT NULL AUTO_INCREMENT,
  organization_type_code   VARCHAR(50),
  organization_description VARCHAR(100),
  is_active                TINYINT(1),
  PRIMARY KEY (organization_type_id)
)
  ENGINE = InnoDB;

--
-- Table structure for contact_type
--

CREATE TABLE contact_type (
  contact_type_id     INT UNSIGNED NOT NULL AUTO_INCREMENT,
  contact_type_code   VARCHAR(50),
  contact_description VARCHAR(100),
  added_date DATETIME,
  is_active TINYINT(1),
  PRIMARY KEY (contact_type_id)
)
  ENGINE = InnoDB;

--
-- Table structure for organization
--

CREATE TABLE organization (
  organization_id      INT UNSIGNED NOT NULL AUTO_INCREMENT,
  organization_type_id INT UNSIGNED,
  organization_name    VARCHAR(50),
  organization_address VARCHAR(50),
  description          VARCHAR(100),
  is_active            TINYINT(1),
  PRIMARY KEY (organization_id),
  CONSTRAINT fk_ORGANIZATION_TYPE_ID_FOR_ORGANIZATION FOREIGN KEY (organization_type_id) REFERENCES organization_type (organization_type_id)
)
  ENGINE = InnoDB;

--
-- Table structure for activity
--

CREATE TABLE activity (
  activity_id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
  activity_type_id     INT UNSIGNED,
  activity_property_id  INT UNSIGNED,
  added_by             INT UNSIGNED,
  updated_by           INT UNSIGNED,
  activity_code        VARCHAR(50),
  activity_description VARCHAR(100),
  start_date           TIMESTAMP,
  end_date             TIMESTAMP,
  start_time           VARCHAR(10),
  end_time             VARCHAR(10),
  added_date           TIMESTAMP,
  updated_date         TIMESTAMP,
  is_available         TINYINT(1),
  PRIMARY KEY (activity_id),
  CONSTRAINT fk_ACTIVITY_TYPE_ID_FOR_ACTIVITY FOREIGN KEY (activity_type_id) REFERENCES activity_type (activity_type_id),
  CONSTRAINT fk_ACTIVITY_PROPERTY_ID_FOR_ACTIVITY FOREIGN KEY (activity_property_id) REFERENCES activity_property (activity_property_id),
  CONSTRAINT fk_ADDED_BY_FOR_ACTIVITY FOREIGN KEY (added_by) REFERENCES user (user_id),
  CONSTRAINT fk_UPDATED_BY_FOR_ACTIVITY FOREIGN KEY (updated_by) REFERENCES user (user_id)
)
  ENGINE = InnoDB;

--
-- Table structure for activity_organization
--

CREATE TABLE activity_organization (
  activity_organization_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  activity_id              INT UNSIGNED,
  organization_id          INT UNSIGNED,
  is_active                TINYINT(1),
  PRIMARY KEY (activity_organization_id),
  CONSTRAINT fk_ACTIVITY_ID_FOR_ACTIVITY_ORGANIZATION FOREIGN KEY (activity_id) REFERENCES activity (activity_id),
  CONSTRAINT fk_ORGANIZATION_ID_FOR_ACTIVITY_ORGANIZATION FOREIGN KEY (organization_id) REFERENCES organization (organization_id)
)
  ENGINE = InnoDB;

--
-- Table structure for activity_location
--

CREATE TABLE activity_location (
  location_id INT UNSIGNED NOT NULL,
  activity_id INT UNSIGNED NOT NULL,
  PRIMARY KEY (location_id, activity_id),
  CONSTRAINT fk_LOCATION_ID_FOR_ACTIVITY_LOCATION FOREIGN KEY (location_id) REFERENCES location (location_id),
  CONSTRAINT fk_ACTIVITY_ID_FOR_ACTIVITY_LOCATION FOREIGN KEY (activity_id) REFERENCES activity (activity_id)
)
  ENGINE = InnoDB;

--
-- Table structure for offer
--

CREATE TABLE offer (
  offer_id                 INT UNSIGNED NOT NULL AUTO_INCREMENT,
  activity_organization_id INT UNSIGNED,
  added_by                 INT UNSIGNED,
  added_date               TIMESTAMP,
  updated_by               INT UNSIGNED,
  updated_date             TIMESTAMP,
  offer_code               VARCHAR(50),
  given_discount           DOUBLE,
  start_date               TIMESTAMP,
  expire_date              TIMESTAMP,
  discription              VARCHAR(100),
  PRIMARY KEY (offer_id),
  CONSTRAINT fk_ACTIVITY_ORGANIZATION_ID_FOR_OFFER FOREIGN KEY (activity_organization_id) REFERENCES activity_organization (activity_organization_id),
  CONSTRAINT fk_ADDED_BY_FOR_offer FOREIGN KEY (added_by) REFERENCES user (user_id),
  CONSTRAINT fk_UPDATED_BY_FOR_offer FOREIGN KEY (updated_by) REFERENCES user (user_id)
)
  ENGINE = InnoDB;

--
-- Table structure for payment
--

CREATE TABLE payment (
  payment_id               INT UNSIGNED NOT NULL AUTO_INCREMENT,
  activity_organization_id INT UNSIGNED,
  amount                   DOUBLE,
  payment_date             TIMESTAMP,
  PRIMARY KEY (payment_id),
  CONSTRAINT fk_ACTIVITY_ORGANIZATION_ID_FOR_PAYMENT FOREIGN KEY (activity_organization_id) REFERENCES activity_organization (activity_organization_id)
)
  ENGINE = innoDB;

--
-- Table structure for organization_contact
--

CREATE TABLE organization_contact (
  contact_id      INT UNSIGNED NOT NULL AUTO_INCREMENT,
  organization_id INT UNSIGNED,
  contact_type_id INT UNSIGNED,
  contact_code    VARCHAR(50),
  description     VARCHAR(100),
  contract_date   TIMESTAMP,
  is_active       TINYINT,
  added_date      TIMESTAMP,
  updated_date    TIMESTAMP,
  PRIMARY KEY (contact_id),
  CONSTRAINT fk_ORGANIZATION_ID_FOR_ORGANIZATION_CONTACT FOREIGN KEY (organization_id) REFERENCES organization (organization_id),
  CONSTRAINT fk_CONTACT_TYPE_ID_FOR_ORGANIZATION_CONTACT FOREIGN KEY (contact_type_id) REFERENCES contact_type (contact_type_id)
)
  ENGINE = InnoDB;