import React from 'react'
import './Sidebar.css'
import logo from '../../assets/react.svg'

const Sidedar = () => {
  return (    
    <aside className='sidebar sb-expandida'>
      <nav>
        <ul>
          <li>
            <a href="#" class="active">
              <i class="bx bx-home-circle"></i>
              <span>Dashboard</span>
            </a>
          </li>
          <li>
            <a href="#">
              <i class="bx bx-grid-alt"></i>
              <span>Explore</span>
            </a>
          </li>
          <li>
            <a href="#">
              <i class="bx bx-carousel"></i>
              <span>Slideshow</span>
            </a>
          </li>
          <li>
            <a href="#">
              <i class="bx bx-collection"></i>
              <span>Collections</span>
            </a>
          </li>
          <li>
            <a href="#">
              <i class="bx bx-cloud-download"></i>
              <span>Downloads</span>
            </a>
          </li>
          <li>
            <a href="#">
              <i class="bx bx-chat"></i>
              <span>Messages</span>
            </a>
          </li>
          <li>
            <a href="#">
              <i class="bx bx-cog"></i>
              <span>Settings</span>
            </a>
          </li>
          <li>
            <a href="#" data-resize-btn>
              <i class="bx bx-chevrons-right"></i>
              <span>Collapse</span>
            </a>
          </li>
        </ul>
      </nav>
    </aside>
  )
}

export default Sidedar
