<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class StudentController extends CI_Controller {

    public function __construct() {
        parent::__construct();
        $this->load->model('Q221Student_model');
    }

    public function insert_students() {
        $this->Student_model->insert_students();
        echo "5 records inserted successfully.";
    }
}
?>


