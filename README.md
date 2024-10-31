# Mood Tracker Application

[Presentation](https://www.canva.com/design/DAGVLFognrI/-8JMjiodHWoGJJOjStStzQ/edit)

## Overview

A simple mood-tracking application that allows users to log their daily emotional state and gain insights into their mood patterns over time.

### Key Features

- **Mood Selection**: Users can select a mood from a set of predefined options (e.g., happy, sad, tense, tired).
- **Notes**: Users can add notes to each day’s entry, providing context for their mood.
- **Mood Trends Visualization**: The app generates charts that display mood fluctuations over different timeframes (day, week, or month).
- **Mood Statistics**: A summary of the most frequent moods to help users understand common emotional states.
- **User-Friendly Interface**: Minimalistic and intuitive design accessible on all devices.

### Technology Stack

- **Backend**: Java, Spring Boot, Spring Data, Spring Security
- **Database**: PostgreSQL with Hibernate ORM
- **Hosting**: DigitalOcean
- **Version Control**: GitLab

## Setup and Installation

1. **Clone the repository**:
    ```bash
    git clone https://gitlab.com/your-repository/mood-tracker-app.git
    ```

2. **Navigate to the project directory**:
    ```bash
    cd mood-tracker-app
    ```

3. **Configure the Database**:
   - Set up a **PostgreSQL database**.
   - Update the database configuration in `application.properties` to match your database credentials.

4. **Run the Application**:
    ```bash
    ./mvnw spring-boot:run
    ```

5. **Access the Application**:
   - Open your browser and go to `http://localhost:8080`.

## Usage

1. **Log in** or **create an account**.
2. **Select a mood** from the available options each day.
3. Optionally, **add a note** to provide additional context for your mood.
4. **View mood trends** to explore patterns over time.
5. Access a **summary of common emotional states** to gain insights into your typical mood.

## License

This project is licensed under the **MIT License**.

---

Enjoy tracking your moods and gaining insights into your emotional well-being with the Mood Tracker application!
