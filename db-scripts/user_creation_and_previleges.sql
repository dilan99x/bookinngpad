CREATE USER 'bookingpad_user'@'localhost' IDENTIFIED BY 'bookingpad@7777';

GRANT ALL PRIVILEGES ON bookingpad.* TO 'bookingpad_user'@'localhost';

-- Once you have finalized the permissions that you want to set up for your new users, always be sure to reload all the privileges.
-- for that you need to execute following command. Your changes will now be in effect.

FLUSH PRIVILEGES;

--
-- Create data base
--
CREATE DATABASE IF NOT EXISTS bookingpad CHARACTER SET utf8 COLLATE utf8_general_ci;

--
-- Use database 
--
USE bookingpad;
