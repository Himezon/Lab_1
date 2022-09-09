<?php
session_start();
date_default_timezone_set('Europe/Moscow');
$start = microtime(true);
$isValid = true;
//echo is_numeric($_GET['x']) && is_numeric($_GET['y']) && is_numeric($_GET['r']);
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $xStr = $_REQUEST['x'];
    $yStr = $_REQUEST['y'];
    $rStr = $_REQUEST['r'];
    $x = $xStr;
    $y = $yStr;
    $r = $rStr;
    $out = "";
    $now = date("H:i:s");
    $now .= "⏰";
    $response = "";
//    $maximum = 12;
    if (!isset($_SESSION['data'])) {
    $_SESSION['data'] = array();
    }


    if (!is_numeric($x) || !is_numeric($y) || !is_numeric($r))
        $isValid = false;
//    if (strlen($x) > $maximum || strlen($y) > $maximum || strlen($r) > $maximum)
//        $isValid = false;
    if ($x < -2 || $x > 2)
        $isValid = false;
    if ($y < -5 || $y > 3)
        $isValid = false;
    if ($r < 2 || $r > 5)
        $isValid = false;
    if (!$isValid) {
        header("Status: 400 Bad Request", true, 400);
        exit;
    }

    if ($x < $r && $y < $r && $y >= 0 && $x >= 0
    || $x <= $y + 0.5*$r && $y <= 0 && $x >= 0
    || $x*$x+$y*$y < $r*$r && $y <= 0 && $x <= 0) {
        $out = "<span style='color: lime'>True</span>";
    } else {
        $out = "<span style='color: red'>False</span>";
    }

    $calc_time = microtime(true) - $start;
    $answer = array($xStr, $yStr, $rStr, $out, $now, number_format($calc_time, 10, ".", "") . " sec");
//    $_SESSION['data'][] = $answer;
} else {
     $answer = array('PLEASE', 'USE', 'ANOTHER', 'METHOD', 'FOR', 'SENDING!');
}
array_push($_SESSION['data'], $answer);
?>
<table align="center" class="result_table">
    <tr>
        <th class="variable">X</th>
        <th class="variable">Y</th>
        <th class="variable">R</th>
        <th>Result</th>
        <th>Submit time</th>
        <th>Calculation time</th>
    </tr>
    <?php
    foreach ($_SESSION['data'] as $word) { ?>
        <tr>
            <td><?php echo $word[0] ?></td>
            <td><?php echo $word[1] ?></td>
            <td><?php echo $word[2] ?></td>
            <td><?php echo $word[3] ?></td>
            <td><?php echo $word[4] ?></td>
            <td><?php echo $word[5] ?></td>
        </tr>
    <?php } ?>
</table>
