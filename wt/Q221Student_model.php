<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Student_model extends CI_Model {

    public function __construct() {
        parent::__construct();
        $this->load->database();
    }

    public function insert_students() {
        $data = array(
            array('name' => 'John Doe', 'class' => '10th'),
            array('name' => 'Jane Smith', 'class' => '11th'),
            array('name' => 'Alice Johnson', 'class' => '9th'),
            array('name' => 'Bob Williams', 'class' => '12th'),
            array('name' => 'Emma Brown', 'class' => '8th')
        );
        
        $this->db->insert_batch('student', $data);
    }
}
?>


<!-- http://localhost/practical%20php/sem6%20php/Q221Student_model.php/Q221StudentController/insert_records -->