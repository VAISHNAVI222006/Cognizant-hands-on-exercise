DELIMITER //
#exercise 1 scenario 1
CREATE PROCEDURE ApplySeniorCitizenDiscount()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE v_customer_id VARCHAR(20);
    DECLARE v_dob DATE;
    DECLARE v_loan_id VARCHAR(20);
    DECLARE v_interest_rate DECIMAL(5,2);
    DECLARE v_age INT;
    DECLARE v_discounted_rate DECIMAL(5,2);
    
    DECLARE cur_customers CURSOR FOR
        SELECT c.customer_id, c.date_of_birth, l.loan_id, l.interest_rate
        FROM Customers c
        JOIN Loans l ON c.customer_id = l.customer_id;
    
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'Error occurred' AS Error_Message;
    END;
    
    START TRANSACTION;
    
    OPEN cur_customers;
    
    read_loop: LOOP
        FETCH cur_customers INTO v_customer_id, v_dob, v_loan_id, v_interest_rate;
        IF done THEN
            LEAVE read_loop;
        END IF;
        
        -- Calculate age
        SET v_age = TIMESTAMPDIFF(YEAR, v_dob, CURDATE());
        
        IF v_age > 60 THEN
            SET v_discounted_rate = v_interest_rate - 1;
            IF v_discounted_rate < 0 THEN
                SET v_discounted_rate = 0;
            END IF;
            
            UPDATE Loans
            SET interest_rate = v_discounted_rate
            WHERE loan_id = v_loan_id;
            
            SELECT CONCAT('Applied 1% discount to customer: ', v_customer_id, 
                         ' (Age: ', v_age, ', New Rate: ', v_discounted_rate, '%)') AS Message;
        END IF;
    END LOOP;
    
    CLOSE cur_customers;
    COMMIT;
END //

DELIMITER ;

#scenario 2
  DELIMITER //

CREATE PROCEDURE UpdateVIPStatus()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE v_customer_id VARCHAR(20);
    DECLARE v_balance DECIMAL(15,2);
    
    DECLARE cur_customers CURSOR FOR
        SELECT customer_id, balance FROM Customers;
    
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'Error occurred' AS Error_Message;
    END;
    
    START TRANSACTION;
    
    OPEN cur_customers;
    
    read_loop: LOOP
        FETCH cur_customers INTO v_customer_id, v_balance;
        IF done THEN
            LEAVE read_loop;
        END IF;
        
        IF v_balance > 10000 THEN
            UPDATE Customers
            SET is_vip = 'Y'
            WHERE customer_id = v_customer_id;
            
            SELECT CONCAT('Customer ', v_customer_id, ' promoted to VIP status.') AS Message;
        ELSE
            UPDATE Customers
            SET is_vip = 'N'
            WHERE customer_id = v_customer_id;
        END IF;
    END LOOP;
    
    CLOSE cur_customers;
    COMMIT;
END //

DELIMITER ;

-- Execute
CALL UpdateVIPStatus();
#scenario3
  DELIMITER //

CREATE PROCEDURE SendLoanDueReminders()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE v_loan_id VARCHAR(20);
    DECLARE v_customer_id VARCHAR(20);
    DECLARE v_due_date DATE;
    DECLARE v_name VARCHAR(100);
    DECLARE v_email VARCHAR(100);
    DECLARE v_days_until_due INT;
    DECLARE v_count INT DEFAULT 0;
    
    DECLARE cur_due_loans CURSOR FOR
        SELECT l.loan_id, l.customer_id, l.due_date, c.name, c.email
        FROM Loans l
        JOIN Customers c ON l.customer_id = c.customer_id
        WHERE l.due_date BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY)
        AND l.status = 'ACTIVE'
        ORDER BY l.due_date;
    
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SELECT 'Error occurred' AS Error_Message;
    END;
    
    OPEN cur_due_loans;
    
    read_loop: LOOP
        FETCH cur_due_loans INTO v_loan_id, v_customer_id, v_due_date, v_name, v_email;
        IF done THEN
            LEAVE read_loop;
        END IF;
        
        SET v_days_until_due = DATEDIFF(v_due_date, CURDATE());
        SET v_count = v_count + 1;
        
        SELECT CONCAT('--- REMINDER MESSAGE ---') AS '';
        SELECT CONCAT('To: ', v_name, ' (', v_email, ')') AS '';
        SELECT CONCAT('Subject: Loan Payment Reminder') AS '';
        SELECT CONCAT('Dear ', v_name, ',') AS '';
        SELECT CONCAT('Your loan (ID: ', v_loan_id, ') is due in ', v_days_until_due, ' days.') AS '';
        SELECT CONCAT('Due Date: ', DATE_FORMAT(v_due_date, '%d-%b-%Y')) AS '';
        SELECT 'Please ensure timely payment to avoid penalties.' AS '';
        SELECT '--- END REMINDER ---' AS '';
        SELECT '' AS '';
    END LOOP;
    
    CLOSE cur_due_loans;
    SELECT CONCAT('Total reminders sent: ', v_count) AS Message;
END //

DELIMITER ;

-- Execute
CALL SendLoanDueReminders();


